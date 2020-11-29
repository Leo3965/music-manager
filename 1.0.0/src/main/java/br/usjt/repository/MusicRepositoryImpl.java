package br.usjt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.usjt.entity.Genre;
import br.usjt.entity.Music;
import br.usjt.entity.User;
import br.usjt.interfaces.repositories.MusicRepository;
import br.usjt.services.MysqlDriver;

public class MusicRepositoryImpl implements MusicRepository {

    private MysqlDriver driver;

    public MusicRepositoryImpl(MysqlDriver driver) {
        this.driver = driver;
    }

    @Override
    public void create(Music data) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Music data) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Music> getByKey(String key, String value) {
        String sql = String.format("SELECT * FROM music where %s = (?)", key);

        try (Connection conn = this.driver.getConnection(); PreparedStatement psQueryUser = conn.prepareStatement(sql);) {
            psQueryUser.setString(1, value);
            ResultSet rs = psQueryUser.executeQuery();
            List<Music> musics = new ArrayList<Music>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                musics.add(new Music(id, name));
            }
            return musics;
        } catch (Exception e) {
            return new ArrayList<Music>();
        }
    }

    @Override
    public List<Music> getByGenre(Genre genre) {
        String sql = "SELECT * FROM music inner join music_genres on music_genres.musicId = music.id where genreId = (?)";

        try (Connection conn = this.driver.getConnection(); PreparedStatement psQueryUser = conn.prepareStatement(sql);) {
            psQueryUser.setInt(1, genre.getId());
            ResultSet rs = psQueryUser.executeQuery();
            List<Music> musics = new ArrayList<Music>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Music music = new Music(id, name);
                music.addGenre(genre);
                musics.add(music);
            }
            return musics;
        } catch (Exception e) {
            return new ArrayList<Music>();
        }
    }

    public List<Music> getMusicForAvaliations(Genre genre, User user) {
        String sql = "SELECT * FROM music inner join music_genres on music_genres.musicId = music.id left join avaliations on (avaliations.musicId = music.id and avaliations.userId = (?))  where genreId = (?) and score is null";

        try (Connection conn = this.driver.getConnection(); PreparedStatement psQueryUser = conn.prepareStatement(sql);) {
            psQueryUser.setInt(1, user.getId());
            psQueryUser.setInt(2, genre.getId());
            ResultSet rs = psQueryUser.executeQuery();
            List<Music> musics = new ArrayList<Music>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Music music = new Music(id, name);
                music.addGenre(genre);
                musics.add(music);
            }
            return musics;
        } catch (Exception e) {
            return new ArrayList<Music>();
        }
    }
    
}
