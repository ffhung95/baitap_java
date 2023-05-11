package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.MySQLConnecttion;
import model.loaiHang;
public class loaiHangHoaRepository extends DAO<loaiHang> {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;
	@Override
	public ArrayList<loaiHang> getAll() throws SQLException {
		 ArrayList<loaiHang> foodCategories = new ArrayList<>();
		 try {
		 connection = MySQLConnecttion.getConnection();
	        String query = "SELECT * FROM loaihang";
	        statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
	        while (rs.next()) {
	        	loaiHang foodCategory = loaiHang.getFromResultSet(rs);
	            foodCategories.add(foodCategory);
	        }
		 } catch (SQLException e) {
				System.out.println("Không thể kết nối đến cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					statement.close();
					rs.close();
				} catch (SQLException e) {
					System.out.println("Lỗi đóng kết nối");
					e.printStackTrace();
				}
			}
			return foodCategories;
	}

	@Override
	public loaiHang get(int id) throws SQLException {
		 try {
			 connection = MySQLConnecttion.getConnection();
	        String query = "SELECT * FROM loaihang WHERE maloaihang = " + id;
	        statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
	        if (rs.next()) {
	        	loaiHang foodCategory = loaiHang.getFromResultSet(rs);
	            return foodCategory;
	        }
		 } catch (SQLException e) {
				System.out.println("Không thể kết nối đến cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					statement.close();
					rs.close();
				} catch (SQLException e) {
					System.out.println("Lỗi đóng kết nối");
					e.printStackTrace();
				}
			}
			return null;
	}

	@Override
	public void save(loaiHang t) throws SQLException {
		
		 if (t == null) {
	            throw new SQLException("FoodCategory rỗng");
	        }
		 try {
			 connection = MySQLConnecttion.getConnection();
	        String query = "INSERT INTO loaihang ( tenloaihang  ) VALUES (?)";

	        statement = connection.prepareStatement(query);
	        statement.setNString(1, t.getTenLoaiHang());
	        int row = statement.executeUpdate();
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
	public void update(loaiHang t) throws SQLException {
		try {
		  if (t == null) {
	            throw new SQLException("FoodCategory rỗng");
	        }
		  	connection = MySQLConnecttion.getConnection();
	        String query = "UPDATE loaihang SET tenloaihang = ? WHERE maloaihang = ?";
	        statement = connection.prepareStatement(query);
	        statement.setNString(1, t.getTenLoaiHang());
//	        statement.setInt(3, t.getMaLoaiang());
	     int ketQua = statement.executeUpdate();
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
	public void delete(loaiHang t) throws SQLException {
		try {
			connection = MySQLConnecttion.getConnection();
			String query = "DELETE from btl_qlcf.loaihang " + " WHERE maloaihang=?";
			statement = connection.prepareStatement(query);
//			statement.setInt(1, t.getMaLoaiang());
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

	@Override
	public void deleteById(int id) throws SQLException {
		try {
		connection = MySQLConnecttion.getConnection();
		String query = "DELETE from btl_qlcf.loaihang " + " WHERE maloaihang=?";
		statement = connection.prepareStatement(query);
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
	   public loaiHang findByName(String name) throws SQLException {
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM loaihang WHERE tenloaihang = '" + name + "'";
	        ResultSet rs = statement.executeQuery(query);
	        if (rs.next()) {
	        	loaiHang foodCategory = loaiHang.getFromResultSet(rs);
	            return foodCategory;
	        }
	        return null;
	    }
	   public ArrayList<loaiHang> searchByKey(String key, String word) throws SQLException {
	        ArrayList<loaiHang> foodCategorys = new ArrayList<>();
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM loaihang WHERE " + key + " LIKE %" + word + "%;";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	loaiHang foodCategory = loaiHang.getFromResultSet(rs);
	            foodCategorys.add(foodCategory);
	        }
	        return foodCategorys;
	    }
}
