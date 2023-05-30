package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.MySQLConnecttion;
import model.HoaDon;


public class HoaDonRepository extends DAO<HoaDon>{
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	@Override
	public ArrayList<HoaDon> getAll() throws SQLException {
		ArrayList<HoaDon> hoaDon = new ArrayList<>();
		Statement statement = conn.createStatement();
		String query = "SELECT hoadon.* ,ban.maban,ban.name,ban.status FROM hoadon "+
				"LEFT JOIN ban on ban.maban=hoadon.maban";
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			HoaDon hoadon = HoaDon.getFromResultSet(rs);
			hoaDon.add(hoadon);
		}
		return hoaDon;
		
	}

	@Override
	public HoaDon get(int id) throws SQLException {
		Statement statement = conn.createStatement();
		String query = "SELECT * FROM hoadon WHERE MAHD = " + id;
		ResultSet rs = statement.executeQuery(query);
		if (rs.next()) {
			HoaDon hoaDon = HoaDon.getFromResultSet(rs);
			return hoaDon;
		}
		return null;
	}

	@Override
	public void save(HoaDon t) throws SQLException {
		if (t == null) {
			throw new SQLException("Hóa đơn rỗng");
		}
		try {
			connection = MySQLConnecttion.getConnection();
			String query = "INSERT INTO hoadon ( maban, TONGTIEN) VALUES ( ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, t.getBan().getMaBan());
			statement.setFloat(2, t.getTongTien());
			int row = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối cơ sỡ dữ liệu");
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
	public void update(HoaDon t) throws SQLException {
		
	}

	@Override
	public void delete(HoaDon t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
