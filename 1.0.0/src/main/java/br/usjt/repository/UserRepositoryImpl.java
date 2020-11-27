package br.usjt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.usjt.entity.Avaliation;
import br.usjt.entity.Genre;
import br.usjt.entity.User;
import br.usjt.interfaces.repositories.UserRepository;
import br.usjt.services.MysqlDriver;

public class UserRepositoryImpl implements UserRepository {

    private MysqlDriver driver;

    public UserRepositoryImpl(MysqlDriver driver) {
        this.driver = driver;
    }

    public void create(User data) {
        String sql = "INSERT INTO users (email, name, password) values (?, ?, ?)";
        try (Connection conn = this.driver.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, data.getEmail());
            ps.setString(2, data.getName());
            ps.setString(3, data.getPassword());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Avaliation> getAvaliationsByUser(User user) {
        String sql = "SELECT * FROM avaliations where userId = (?)";

        try (Connection conn = this.driver.getConnection(); PreparedStatement psQueryUser = conn.prepareStatement(sql);) {
            psQueryUser.setInt(1, user.getId());
            ResultSet rs = psQueryUser.executeQuery();
            List<Avaliation> avaliations = new ArrayList<Avaliation>();

            while (rs.next()) {
                int id = rs.getInt("id");
                Short score = rs.getShort("score");
                avaliations.add(new Avaliation(id, score));
            }
            return avaliations;
        } catch (Exception e) {
            return new ArrayList<Avaliation>();
        }
    }

    private List<Genre> getGenresByUser(User user) {
        String sql = "SELECT * FROM genres INNER JOIN user_genres ON user_genres.genreId = genres.id WHERE userId = (?)";

        try (Connection conn = this.driver.getConnection(); PreparedStatement psQueryUser = conn.prepareStatement(sql);) {
            psQueryUser.setInt(1, user.getId());
            ResultSet rs = psQueryUser.executeQuery();
            List<Genre> genres = new ArrayList<Genre>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String date = rs.getString("date");
                genres.add(new Genre(id, name, date));
            }
            return genres;
        } catch (Exception e) {
            return new ArrayList<Genre>();
        }
    }

    public List<User> getByKey(String key, String value) {
        String sql = String.format("SELECT * FROM users where %s = (?)", key);

        try (Connection conn = this.driver.getConnection(); PreparedStatement psQueryUser = conn.prepareStatement(sql);) {
            psQueryUser.setString(1, value);
            ResultSet rs = psQueryUser.executeQuery();
            List<User> users = new ArrayList<User>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                User fetchedUser = new User(id, name, password, email);
                for(Avaliation avaliation: this.getAvaliationsByUser(fetchedUser)) {
                    fetchedUser.addAvaliation(avaliation);
                }
                for(Genre genre: this.getGenresByUser(fetchedUser)) {
                    fetchedUser.addGenre(genre);
                }
                users.add(fetchedUser);
            }
            return users;
        } catch (Exception e) {
            return new ArrayList<User>();
        }
    }

    public void update(User user) {
        String sqlUpdateUser = "UPDATE users set name = ?, email = ?, password = ? where id = ?";
        try (
            Connection conn = this.driver.getConnection();
            PreparedStatement psUpdateUser = conn.prepareStatement(sqlUpdateUser)
            ) {
            
            psUpdateUser.setString(1, user.getName());
            psUpdateUser.setString(2, user.getEmail());
            psUpdateUser.setString(3, user.getPassword());
            psUpdateUser.setInt(4, user.getId());
            psUpdateUser.execute();

            String sqlDeleteGenre = "DELETE FROM user_genres where userId = ?";

            try (PreparedStatement psDeleteGenre = conn.prepareStatement(sqlDeleteGenre)) {
                psDeleteGenre.setInt(1, user.getId());
                psDeleteGenre.execute();
                for (Genre genre : user.getGenres()) {
                    String sqlInsertGenre = "INSERT INTO user_genres (genreId, userId) values (?, ?)";

                    try (PreparedStatement psInsertGenre = conn.prepareStatement(sqlInsertGenre)){
                        psInsertGenre.setInt(1, genre.getId());
                        psInsertGenre.setInt(2, user.getId());
                        psInsertGenre.execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String sqlDeleteAvaliation = "DELETE FROM avaliations where userId = ?";

            try (PreparedStatement psDeleteAvaliation = conn.prepareStatement(sqlDeleteAvaliation)) {
                psDeleteAvaliation.setInt(1, user.getId());
                psDeleteAvaliation.execute();
                for(Avaliation avaliation : user.getAvaliations()) {
                    String sqlInsertAvaliation = "INSERT INTO avaliations (score, musicId, userId) values (?, ?, ?)";

                    try (PreparedStatement psInsertAvaliation = conn.prepareStatement(sqlInsertAvaliation)) {
                        psInsertAvaliation.setInt(1, avaliation.getId());
                        psInsertAvaliation.setInt(2, avaliation.getMusic().getId());
                        psInsertAvaliation.setInt(3, user.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
