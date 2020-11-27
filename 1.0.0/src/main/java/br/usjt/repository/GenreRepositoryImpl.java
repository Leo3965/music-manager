package br.usjt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.usjt.entity.Genre;
import br.usjt.entity.User;
import br.usjt.interfaces.repositories.GenreRepository;
import br.usjt.drivers.MysqlDriver;

public class GenreRepositoryImpl implements GenreRepository {

    private MysqlDriver driver;

    public GenreRepositoryImpl(MysqlDriver driver) {
        this.driver = driver;
    }

    public void create(Genre data) {
        String sql = "INSERT INTO genres (name) values (?)";
        try (Connection conn = this.driver.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, data.getName());
            ps.execute();
        } catch (Exception e) {

        }
    }

    public List<Genre> getByKey(String key, String value) {
        String sql = String.format("SELECT * FROM genres where %s = (?)", key);

        try (Connection conn = this.driver.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            List<Genre> genres = new ArrayList<Genre>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                genres.add(new Genre(id, name));
            }
            return genres;
        } catch (Exception e) {
            return new ArrayList<Genre>();
        }
    }

    public List<Genre> getByUser(User user) {
        String sql = "SELECT * FROM genres INNER JOIN user_genres on user_genres.genreId = genres.Id where user_genres.userId = (?)";

        try (Connection conn = this.driver.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
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

    public List<Genre> getAll() {
        String sql = "SELECT * FROM genres";

        try (Connection conn = this.driver.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            List<Genre> genres = new ArrayList<Genre>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                genres.add(new Genre(id, name));
            }
            return genres;
        } catch (Exception e) {
            return new ArrayList<Genre>();
        }
    }

    public void update(Genre data) {
    }

}
