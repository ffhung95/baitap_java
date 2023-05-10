package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.MySQLConnecttion;
import model.datHang;

public class datHangRepository extends DAO<datHang>{
	NhanVienReposity employeeDao = new NhanVienReposity();
    tableRepository tableDao = new tableRepository();
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet rs = null;
	@Override
	public ArrayList<datHang> getAll() throws SQLException {
		  ArrayList<datHang> orders = new ArrayList<>();
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM dathang ORDER BY orderDate DESC";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	datHang order = datHang.getFromResultSet(rs);
	            order.setNhanvien(employeeDao.get(order.getIdNV()));
	            order.setBan(tableDao.get(order.getIdBan()));
	            orders.add(order);
	        }
	        return orders;
	}
    public ArrayList<datHang> getAll(int idEmployee) throws SQLException {
        ArrayList<datHang> orders = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM dathang  WHERE idnv= '" + idEmployee + "' ORDER BY orderDate DESC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
        	datHang order = datHang.getFromResultSet(rs);
        	 order.setNhanvien(employeeDao.get(order.getIdNV()));
	         order.setBan(tableDao.get(order.getIdBan()));
            orders.add(order);
        }
        return orders;
    }

	@Override
	public datHang get(int id) throws SQLException {
		 Statement statement = conn.createStatement();
	        String query = "SELECT * FROM dathang WHERE id = " + id;
	        ResultSet rs = statement.executeQuery(query);
	        if (rs.next()) {
	        	datHang order = datHang.getFromResultSet(rs);
	        	 order.setNhanvien(employeeDao.get(order.getIdNV()));
		         order.setBan(tableDao.get(order.getIdBan()));
	            return order;
	        }
	        return null;
	}

	@Override
	public void save(datHang t) throws SQLException {
		
		try {
		   if (t == null) {
	            throw new SQLException("Order rỗng");
	        }
		   connection = MySQLConnecttion.getConnection();
	        String query = "INSERT INTO dathang (idban, orderDate, payDate, total, discount) VALUES (?, current_timestamp(), NULL, ?,?)";
	        statement = connection.prepareStatement(query);
	       
	        statement.setInt(1, t.getIdBan());
	        statement.setInt(2, t.getTotal());
	        statement.setInt(3, t.getDiscount());
	       int ketqua = statement.executeUpdate();
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

	@Override
	public void update(datHang t) throws SQLException {
		if (t == null) {
            throw new SQLException("Order rỗng");
        }
        String query = "UPDATE dathang SET idnv = ?, idban = ?, orderDate = ?, payDate = ?, total = ?, discount = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdNV());
        stmt.setInt(2, t.getIdBan());
        stmt.setTimestamp(3, t.getOrderTime());
        stmt.setTimestamp(4, t.getPayTime());
        stmt.setInt(5, t.getTotal());
        stmt.setInt(6, t.getDiscount());
        stmt.setInt(7, t.getId());
        int row = stmt.executeUpdate();
		
	}

	@Override
	public void delete(datHang t) throws SQLException {
		 PreparedStatement stmt = conn.prepareStatement("DELETE FROM dathang WHERE id = ?");
	        stmt.setInt(1, t.getId());
	        stmt.executeUpdate();
	}

	@Override
	public void deleteById(int id) throws SQLException {
		  PreparedStatement stmt = conn.prepareStatement("DELETE FROM dathang WHERE id = ?");
	        stmt.setInt(1, id);
	        stmt.executeUpdate();
	}
	public ArrayList<datHang> searchByKey(String key, String word) throws SQLException {
        ArrayList<datHang> orders = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM dathang WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
        	datHang order = datHang.getFromResultSet(rs);
            order.setNhanvien(employeeDao.get(order.getIdNV()));
            order.setBan(tableDao.get(order.getIdBan()));
            orders.add(order);
        }
        return orders;
    } 
	public void create(datHang t) throws SQLException {
        if (t == null) {
            throw new SQLException("Order rỗng");
        }
        String query = "INSERT INTO dathang (idnv, idban, orderDate, payDate, total, discount) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdNV());
        stmt.setInt(2, t.getIdBan());
        stmt.setTimestamp(5, t.getOrderTime());
        stmt.setTimestamp(6, t.getPayTime());
        stmt.setInt(8, t.getTotal());
        stmt.setInt(9, t.getDiscount());
        int row = stmt.executeUpdate();
    }
	  public ArrayList<datHang> searchByKey(int idEmployee, String key, String word) throws SQLException {
	        ArrayList<datHang> orders = new ArrayList<>();
	        String query = "SELECT * FROM dathang WHERE " + key + " LIKE ? AND id = ?";
	        PreparedStatement statement = conn.prepareStatement(query);
	        statement.setNString(1, String.format("%s%s%s", "%", word, "%"));
	        statement.setInt(2, idEmployee);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	        	datHang order = datHang.getFromResultSet(rs);
	        	 order.setNhanvien(employeeDao.get(order.getIdNV()));
	             order.setBan(tableDao.get(order.getIdBan()));
	            orders.add(order);
	        }
	        return orders;
	    }
	  
	

}
