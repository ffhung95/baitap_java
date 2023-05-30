package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.MySQLConnecttion;
import model.hangHoa;

public class hangHoaRepository extends DAO<hangHoa> {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	@Override
	public ArrayList<hangHoa> getAll() throws SQLException {
		ArrayList<hangHoa> foodItems = new ArrayList<>();
		Statement statement = conn.createStatement();
		String query = "SELECT hanghoa.* , admin.maadmin ,admin.hoten ,loaihang.maloaihang ,loaihang.tenloaihang FROM hanghoa "+
				"LEFT JOIN admin on admin.maadmin=hanghoa.maadmin "+
				"LEFT JOIN loaihang on loaihang.maloaihang=hanghoa.maloaihang";
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			hangHoa foodItem = hangHoa.getFromResultSet(rs);
			foodItems.add(foodItem);
		}
		return foodItems;
	}

	public ArrayList<hangHoa> getByIdCategory(String tenCategory) throws SQLException {
		ArrayList<hangHoa> foodItems = new ArrayList<>();
		Statement statement = conn.createStatement();
		String query = "SELECT * FROM hanghoa WHERE maloaihang = " + tenCategory;
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			hangHoa foodItem = hangHoa.getFromResultSet(rs);
			foodItems.add(foodItem);
		}
		return foodItems;
	}

	@Override
	public hangHoa get(int id) throws SQLException {
		Statement statement = conn.createStatement();
		String query = "SELECT * FROM hanghoa WHERE mahanghoa = " + id;
		ResultSet rs = statement.executeQuery(query);
		if (rs.next()) {
			hangHoa foodItem = hangHoa.getFromResultSet(rs);
			return foodItem;
		}
		return null;
	}
	@Override
	public void deleteById(int id) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM hanghoa WHERE mahanghoa = ?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}

	@Override
	public void save(hangHoa t) throws SQLException {
		if (t == null) {
			throw new SQLException("Food item rá»—ng");
		}
		try {
			connection = MySQLConnecttion.getConnection();
			String query = "INSERT INTO hanghoa (tenhanghoa, giahanghoa, soluong, maloaihang, maadmin, anhhanghoa) VALUES ( ?, ?, ?, ?, ?,?)";
			statement = connection.prepareStatement(query);
			statement.setNString(1, t.getTenHangHoa());
			statement.setFloat(2, t.getGiaHangHoa());
			statement.setInt(3, t.getSoLuong());
			statement.setInt(4, t.getLoaiHang().getMaloaihang());
			statement.setInt(5, t.getDmin().getMaadmin());
			statement.setBytes(6, t.getAnhHangHoa());
			int row = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("KhÃ´ng thá»ƒ káº¿t ná»‘i Ä‘áº¿n cÆ¡ sá»Ÿ dá»¯ liá»‡u");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("Lá»—i Ä‘Ã³ng káº¿t ná»‘i");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(hangHoa t) throws SQLException {
		if (t == null) {
			throw new SQLException("Food item rá»—ng");
		}
		String query = "UPDATE hanghoa SET tenhanghoa = ?, giahanghoa = ?, soluong = ?, maloaihang = ?, maadmin=? , anhhanghoa = ? WHERE mahanghoa = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setNString(1, t.getTenHangHoa());
		stmt.setFloat(2, t.getGiaHangHoa());
		stmt.setInt(3, t.getSoLuong());
		statement.setInt(4, t.getLoaiHang().getMaloaihang());
		statement.setInt(5, t.getDmin().getMaadmin());
		stmt.setBytes(6, t.getAnhHangHoa());
		stmt.setInt(7, t.getMaHangHoa());
		int row = stmt.executeUpdate();

	}
	public void capNhatSoLuong(hangHoa t) throws SQLException {
		if (t == null) {
			throw new SQLException("Food item rá»—ng");
		}
		try {
		connection = MySQLConnecttion.getConnection();
		String query = "UPDATE hanghoa SET  soluong = ? WHERE mahanghoa = ?";
		statement = connection.prepareStatement(query);
		statement.setInt(1, t.getSoLuong());
		statement.setInt(2, t.getMaHangHoa());
		int row = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("KhÃ´ng thá»ƒ káº¿t ná»‘i Ä‘áº¿n cÆ¡ sá»Ÿ dá»¯ liá»‡u");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("Lá»—i Ä‘Ã³ng káº¿t ná»‘i");
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(hangHoa t) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM hanghoa WHERE mahanghoa= ?");
		stmt.setInt(1, t.getMaHangHoa());
		stmt.executeUpdate();

	}

	public ArrayList<hangHoa> searchByKey(String key, String word) throws SQLException {
		ArrayList<hangHoa> fooditems = new ArrayList<>();
		Statement statement = conn.createStatement();
		String query = "SELECT * FROM hanghoa WHERE " + key + " LIKE '%" + word + "%';";
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			hangHoa fooditem = hangHoa.getFromResultSet(rs);
			fooditems.add(fooditem);
		}
		return fooditems;
	}

	public ArrayList<hangHoa> searchByName(String key) throws SQLException {
		ArrayList<hangHoa> fooditems = new ArrayList<>();
		Statement statement = conn.createStatement();
		String query = "SELECT hanghoa.* , admin.maadmin, admin.hoten, loaihang.maloaihang, loaihang.tenloaihang " +
				" FROM hanghoa " +
				" LEFT JOIN admin on admin.maadmin=hanghoa.maadmin " +
				" LEFT JOIN loaihang on loaihang.maloaihang=hanghoa.maloaihang " +
				" WHERE tenhanghoa LIKE '%" + key + "%'";
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			hangHoa fooditem = hangHoa.getFromResultSet(rs);
			fooditems.add(fooditem);
		}
		return fooditems;
	}

	public hangHoa getRandom() throws SQLException {
		Statement statement = conn.createStatement();
		String query = "SELECT * FROM hanghoa WHERE maloaihang != 4 ORDER BY RAND() LIMIT 1";
		ResultSet rs = statement.executeQuery(query);
		if (rs.next()) {
			hangHoa foodItem = hangHoa.getFromResultSet(rs);
			return foodItem;
		}
		return null;
	}

}
