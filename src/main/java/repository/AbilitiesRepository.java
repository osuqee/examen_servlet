package repository;
import models.Abilities;
import connection.*;

import java.util.*;
import java.sql.*;

public class AbilitiesRepository {

    private final AbstractConnection manager = new H2Connection();

    public List<Abilities> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Abilities> abilitiesList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from champion_abilities");
            rs = statement.executeQuery();

            AbilitiesRepository abilitiesRepo = new AbilitiesRepository();

            while (rs.next()) {
                Abilities a = new Abilities();
                a.setId(rs.getInt("id"));
                a.setChampion(rs.getInt("champion"));
                a.setChampion_name(rs.getString("champion_name"));
                a.setChampion_description(rs.getString("champion_description"));
                a.setEffect(rs.getString("effect"));
                a.setCost(rs.getString("cost"));
                a.setRango(rs.getInt("rango"));
                abilitiesList.add(a);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  abilitiesList;
    }

    public void insertOne(Abilities a) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO abilities(id, champion, champion_name, champion_description, effect, cost, rango) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, a.getId());
            statement.setInt(2, a.getChampion());
            statement.setString(3, a.getChampion_name());
            statement.setString(4, a.getChampion_description());
            statement.setString(5, a.getEffect());
            statement.setString(6, a.getCost());
            statement.setInt(7, a.getRango());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }
}
