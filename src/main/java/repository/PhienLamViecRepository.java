package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.MySQLConnecttion;
import model.PhienLamViec;
import model.table;

public class PhienLamViecRepository extends DAO<PhienLamViec>{
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	@Override
	public ArrayList<PhienLamViec> getAll() throws SQLException {
		  ArrayList<PhienLamViec> phienLamViecs = new ArrayList<>();
	        Statement statement = conn.createStatement();
	        String query = "SELECT phienlamviec.*   FROM ban ORDER BY maban ASC , name ASC";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	PhienLamViec phienLamViec = PhienLamViec.getFromResultSet(rs);
	        	phienLamViecs.add(phienLamViec);
	        }
	        return phienLamViecs;
	}
	public ArrayList<PhienLamViec> getAllName() throws SQLException {
		  ArrayList<PhienLamViec> phienLamViecs = new ArrayList<>();
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM ban where name";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	PhienLamViec phienLamViec = PhienLamViec.getFromResultSet(rs);
	        	phienLamViecs.add(phienLamViec);
	        }
	        return phienLamViecs;
	}
	@Override
	public PhienLamViec get(int id) throws SQLException {
		connection = MySQLConnecttion.getConnection();
	        String query = "SELECT phienlamviec.* ,nhanvien.manv,nhanvien.hotennv " +
					"FROM phienlamviec " +
					" LEFT JOIN nhanvien on nhanvien.manv=phienlamviec.manv " +
					" WHERE phienlamviec.maphienlamviec = " + id;
		statement = connection.prepareStatement(query);
		rs = statement.executeQuery();
	        if (rs.next()) {
	        	PhienLamViec phienLamViec = PhienLamViec.getFromResultSet(rs);
	            return phienLamViec;
	        }
	        return null;
	}

	@Override
	public void save(PhienLamViec t) throws SQLException {
		 if (t == null) {
	            throw new SQLException("Nhân viên rỗng");
	        }
	        String query = "INSERT INTO phienlamviec (manv) VALUES (?)";
	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setInt(1, t.getNhanvien().getManv());
	        int row = stmt.executeUpdate();
		
	}

	@Override
	public void update(PhienLamViec t) throws SQLException {
		
	}

	@Override
	public void delete(PhienLamViec t) throws SQLException {
		
	}

	
	@Override
	public void deleteById(int id) throws SQLException {
		try {
		connection = MySQLConnecttion.getConnection();
		String sql = "DELETE from btl_qlcf.phienlamviec " + " WHERE maphienlamviec=?";
		statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.executeUpdate();
	} catch (SQLException e) {
		System.out.println("Không thể kết nối đến cơ sở dữ liệu");
		e.printStackTrace();
	} finally {
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Lỗi đóng kết nối");
			e.printStackTrace();
		}
	}
		
	}

}
