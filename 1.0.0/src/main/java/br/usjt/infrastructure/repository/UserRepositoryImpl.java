package br.usjt.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.usjt.domain.contracts.repositories.UserRepository;
import br.usjt.domain.entity.Genre;
import br.usjt.domain.entity.User;
import br.usjt.infrastructure.drivers.MysqlDriver;

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

    public List<User> getByKey(String key, String value) {
        String sql = String.format("SELECT * FROM users where %s = (?)", key);

        try (Connection conn = this.driver.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            List<User> genres = new ArrayList<User>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                genres.add(new User(id, name, password, email));
            }
            return genres;
        } catch (Exception e) {
            return new ArrayList<User>();
        }
    }

    public void update(User user) {
        String sqlUpdateUser = "UPDATE users set name = ?, email = ?, password = ? where id = ?";
        try (Connection conn = this.driver.getConnection();
                PreparedStatement psUpdateUser = conn.prepareStatement(sqlUpdateUser)) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
