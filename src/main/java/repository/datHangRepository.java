package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.MySQLConnecttion;
import model.DatHang;
import model.loaiHang;


public class datHangRepository extends DAO<DatHang>{
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;
	@Override
	public ArrayList<DatHang> getAll() throws SQLException {
		 ArrayList<DatHang> datHangs = new ArrayList<>();
		 try {
		 connection = MySQLConnecttion.getConnection();
	        String query = "SELECT dathang.*,ban.maban,ban.name,ban.status,phienlamviec.maphienlamviec," +
					" hanghoa.mahanghoa,hanghoa.tenhanghoa FROM dathang "+
					"LEFT JOIN ban on ban.maban=dathang.maban "+
					" LEFT JOIN phienlamviec on phienlamviec.maphienlamviec=dathang.maphienlamviec "+
					" LEFT JOIN hanghoa on hanghoa.mahanghoa=dathang.mahanghoa";
	        statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
	        while (rs.next()) {
	        	DatHang dathang = DatHang.getFromResultSet(rs);
	        	datHangs.add(dathang);
	        }
		 } catch (SQLException e) {
				System.out.println("Không thể kết nối cơ sỡ dữ liệu");
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					statement.close();
					rs.close();
				} catch (SQLException e) {
					System.out.println("Lá»—i Ä‘Ã³ng káº¿t ná»‘i");
					e.printStackTrace();
				}
			}
			return datHangs;
	}

	@Override
	public DatHang get(int id) throws SQLException {
		Statement statement = conn.createStatement();
		String query = "SELECT * FROM dathang WHERE madathang = " + id;
		ResultSet rs = statement.executeQuery(query);
		if (rs.next()) {
			DatHang dathang = DatHang.getFromResultSet(rs);
			return dathang;
		}
		return null;
	}

	@Override
	public void save(DatHang t) throws SQLException {
		if (t == null) {
			throw new SQLException("đăt hàng rỗng");
		}
		try {
			connection = MySQLConnecttion.getConnection();
			String query = "INSERT INTO dathang (maban, maphienlamviec, mahanghoa, soluong, thanhtien) VALUES ( ?, ?, ?, ?,?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, t.getBan().getMaBan());
			statement.setInt(2, t.getNhanvien().getMaPhienLamViec());
			statement.setInt(3, t.getHanghoa().getMaHangHoa());
			statement.setInt(4, t.getSoLuong());
			statement.setFloat(5, t.getThanhTien());
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
	public void update(DatHang t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DatHang t) throws SQLException {
		try {
			connection = MySQLConnecttion.getConnection();
			String sql = "DELETE from btl_qlcf.dathang " + " WHERE madathang=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, t.getMaDatHang());
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
		// TODO Auto-generated method stub
		
	}
	

}
