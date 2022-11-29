package repository;
import models.Champions;
import connection.*;

import java.util.*;
import java.sql.*;

public class ChampionsRepository {

    private final AbstractConnection manager = new H2Connection();
    private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT from './src/main/resources/scripts/lolh2initdata.sql'";
	

    public List<Champions> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Champions> championsList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from champions");
            rs = statement.executeQuery();

            ChampionsRepository championsRepo = new ChampionsRepository();

            while (rs.next()) {
                Champions c = new Champions();
                c.setId(rs.getInt("id"));
                c.setChampion_name(rs.getString("champion_name"));
                c.setTitle(rs.getString("title"));
                c.setLore(rs.getString("lore"));
                c.setTags(rs.getString("tags"));
                championsList.add(c);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  championsList;
    }

    public void delete(int id) {
		Connection conn = manager.open();
		PreparedStatement preparedStatement = null;
		
		try {

			preparedStatement = conn
					.prepareStatement("DELETE FROM items WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

    public void insertOne(Champions c) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO champions(id, champion_name, title, lore, tags) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, c.getId());
            statement.setString(2, c.getChampion_name());
            statement.setString(3, c.getTitle());
            statement.setString(3, c.getLore());
            statement.setString(3, c.getTags());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }
    public int getLastIdChampion() {
		int last_id = 0;
		Connection conn = manager.open();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT max(id) as id FROM champions ");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				last_id = resultSet.getInt("id");
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return last_id;
	}
}
