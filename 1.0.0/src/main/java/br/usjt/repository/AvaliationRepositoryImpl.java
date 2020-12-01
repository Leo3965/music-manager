package br.usjt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.usjt.entity.Avaliation;
import br.usjt.interfaces.repositories.AvaliationRepository;
import br.usjt.services.MysqlDriver;

public class AvaliationRepositoryImpl implements AvaliationRepository {

    private MysqlDriver driver;

    public AvaliationRepositoryImpl(MysqlDriver driver) {
        this.driver = driver;
    }

    @Override
    public void create(Avaliation data) {
        String sql = "INSERT INTO avaliations (score, userId, musicId) values (?, ?, ?)";
        try (Connection conn = this.driver.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setShort(1, data.getScore());
            ps.setInt(2, data.getUser().getId());
            ps.setInt(3, data.getMusic().getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Avaliation data) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Avaliation> getByKey(String key, String value) {
        // TODO Auto-generated method stub
        return null;
    }

   

    
}
