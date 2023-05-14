package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.table;


public class tableRepository extends DAO<table> {

	@Override
	public ArrayList<table> getAll() throws SQLException {
		  ArrayList<table> tables = new ArrayList<>();
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM ban ORDER BY maban ASC , name ASC";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	table Table = table.getFromResultSet(rs);
	            tables.add(Table);
	        }
	        return tables;
	}
	public ArrayList<table> getAllName() throws SQLException {
		  ArrayList<table> tables = new ArrayList<>();
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM ban where name";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	table Table = table.getFromResultSet(rs);
	            tables.add(Table);
	        }
	        return tables;
	}

	@Override
	public table get(int id) throws SQLException {
		 Statement statement = conn.createStatement();
	        String query = "SELECT * FROM ban WHERE maban = " + id;
	        ResultSet rs = statement.executeQuery(query);
	        if (rs.next()) {
	            table Table = table.getFromResultSet(rs);
	            return Table;
	        }
	        return null;
	}

	@Override
	public void save(table t) throws SQLException {
		 if (t == null) {
	            throw new SQLException("Table rỗng");
	        }
	        String query = "INSERT INTO ban (name) VALUES (?)";

	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setNString(1, t.getName());
	        int row = stmt.executeUpdate();
		
	}

	@Override
	public void update(table t) throws SQLException {
		if (t == null) {
            throw new SQLException("Table rỗng");
        }
        String query = "UPDATE ban SET name = ? , status = ? WHERE maban = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getName());
        stmt.setNString(2, t.getTrangthai().getId());
        stmt.setInt(3, t.getMaBan());
        int row = stmt.executeUpdate();
		
	}

	@Override
	public void delete(table t) throws SQLException {
		  PreparedStatement stmt = conn.prepareStatement("DELETE FROM ban WHERE maban = ?");
	        stmt.setInt(1, t.getMaBan());
	        stmt.executeUpdate();
		
	}
	

	@Override
	public void deleteById(int id) throws SQLException {
		   PreparedStatement stmt = conn.prepareStatement("DELETE FROM ban WHERE maban = ?");
	        stmt.setInt(1, id);
	        stmt.executeUpdate();
		
	}
	 public table findByName(String name) throws SQLException {
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM ban WHERE name = '" + name + "'";
	        ResultSet rs = statement.executeQuery(query);
	        if (rs.next()) {
	            table t = table.getFromResultSet(rs);
	            return t;
	        }
	        return null;
	    }
	 public ArrayList<table> searchByKey(String key, String word) throws SQLException {
	        ArrayList<table> tables = new ArrayList<>();
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM ban WHERE " + key + " LIKE '%" + word + "%';";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	table Table = table.getFromResultSet(rs);
	            tables.add(Table);
	        }
	        return tables;
	    }
	 public table getRandom() throws SQLException {
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM ban ORDER BY RAND() LIMIT 1";
	        ResultSet rs = statement.executeQuery(query);
	        if (rs.next()) {
	        	table Table = table.getFromResultSet(rs);
	            return Table;
	        }
	        return null;
	    }

}
