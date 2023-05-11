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
		String query = "SELECT * FROM hanghoa ORDER BY maloaihang ASC , tenhanghoa ASC";
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			hangHoa foodItem = hangHoa.getFromResultSet(rs);
			foodItems.add(foodItem);
		}
		return foodItems;
	}

	public ArrayList<hangHoa> getByIdCategory(int id) throws SQLException {
		ArrayList<hangHoa> foodItems = new ArrayList<>();
		Statement statement = conn.createStatement();
		String query = "SELECT * FROM hanghoa WHERE maloaihang = " + id;
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
		String query = "SELECT * FROM food_item WHERE mahanghoa = " + id;
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

//	int ketqua = 0;
//	try {
//		connection = MySQLConnecttion.getConnection();
//		String query = " INSERT INTO btl_qlcf.admin (taikhoan,matkhau,hoten,sdt,avatar ) " + " VALUES (?,?,?,?,?)";
//		statement = connection.prepareStatement(query);
//		statement.setString(1, kh.getTaikhoan());
//		statement.setString(2, kh.getMatkhau());
//		statement.setString(3, kh.getHoten());
//		statement.setString(4, kh.getSdt());
//		statement.setBytes(5, kh.getAvatar());
//		ketqua = statement.executeUpdate();
//	} catch (SQLException e) {
//		System.out.println("Không thể kết nối đến cơ sở dữ liệu");
//		e.printStackTrace();
//	} finally {
//		try {
//			connection.close();
//			statement.close();
//		} catch (SQLException e) {
//			System.out.println("Lỗi đóng kết nối");
//			e.printStackTrace();
//		}
//	}
//	return ketqua;
	@Override
	public void save(hangHoa t) throws SQLException {
		if (t == null) {
			throw new SQLException("Food item rỗng");
		}
		try {
			connection = MySQLConnecttion.getConnection();
			String query = "INSERT INTO hanghoa (tenhanghoa, giahanghoa, soluong, maloaihang, anhhanghoa) VALUES ( ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setNString(1, t.getTenHangHoa());
			statement.setDouble(2, t.getGiaHangHoa());
			statement.setInt(3, t.getSoLuong());
			statement.setInt(4, t.getIdmaloaihang());
			statement.setString(5, t.getAnhHangHoa());
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
	public void update(hangHoa t) throws SQLException {
		if (t == null) {
			throw new SQLException("Food item rỗng");
		}
		String query = "UPDATE hanghoa SET tenhanghoa = ?, giahanghoa = ?, soluong = ?, maloaihang = ?, manv = ?, anhhanghoa = ? WHERE mahanghoa = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setNString(1, t.getTenHangHoa());
		stmt.setDouble(2, t.getGiaHangHoa());
		stmt.setInt(3, t.getSoLuong());
		stmt.setInt(4, t.getIdmaloaihang());
		stmt.setInt(5, t.getIdNV());
		stmt.setString(6, t.getAnhHangHoa());
		stmt.setInt(7, t.getMaHangHoa());
		int row = stmt.executeUpdate();

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
		String query = "SELECT * FROM hanghoa WHERE tenhanghoa LIKE '%" + key + "%';";
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
