package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import database.MySQLConnecttion;
import model.admin;

public class AdminReposity {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	public List<admin> getAdmin() {

		List<admin> list = new LinkedList<admin>();
		try {
			connection = MySQLConnecttion.getConnection();
			String query = "SELECT * FROM btl_qlcf.admin ";
			statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
			while (rs.next()) {
				admin adminrepository = new admin();
				adminrepository.setMaadmin(rs.getInt("maadmin"));
				adminrepository.setTaikhoan(rs.getString("taikhoan"));
				adminrepository.setMatkhau(rs.getString("matkhau"));
				adminrepository.setHoten(rs.getString("hoten"));
				adminrepository.setSdt(rs.getString("sdt"));
				adminrepository.setAvatar(rs.getBytes("avatar"));
				list.add(adminrepository);
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
		return list;
	}

	public admin selectById(admin t) {
		try {
			connection = MySQLConnecttion.getConnection();
			String query = "SELECT * FROM btl_qlcf.admin WHERE maadmin = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, t.getMaadmin());
			rs = statement.executeQuery();
			while (rs.next()) {
				admin adminrepository = new admin();
				adminrepository.setMaadmin(rs.getInt("maadmin"));
				adminrepository.setTaikhoan(rs.getString("taikhoan"));
				adminrepository.setMatkhau(rs.getString("matkhau"));
				adminrepository.setHoten(rs.getString("hoten"));
				adminrepository.setSdt(rs.getString("sdt"));
				adminrepository.setAvatar(rs.getBytes("avatar"));
				return adminrepository;
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

	public int insertUser(admin kh) {
		int ketqua = 0;
		try {
			connection = MySQLConnecttion.getConnection();
			String query = " INSERT INTO btl_qlcf.admin (taikhoan,matkhau,hoten,sdt,avatar ) " + " VALUES (?,?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, kh.getTaikhoan());
			statement.setString(2, kh.getMatkhau());
			statement.setString(3, kh.getHoten());
			statement.setString(4, kh.getSdt());
			statement.setBytes(5, kh.getAvatar());
			ketqua = statement.executeUpdate();
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
		return ketqua;
	}

	public boolean kiemTraTenTenNhap(String taikhoan) {
		boolean ketQua = false;
		try {
			connection = MySQLConnecttion.getConnection();
			String sql = "SELECT * FROM btl_qlcf.admin WHERE taikhoan=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, taikhoan);
			rs = statement.executeQuery();
			while (rs.next()) {
				ketQua = true;
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			// TODO Auto-generated catch block
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
		return ketQua;
	}

	public boolean kiemTraSoDienThoai(String sodienthoai) {
		boolean ketQua = false;
		try {
			connection = MySQLConnecttion.getConnection();
			String sql = "SELECT * FROM btl_qlcf.admin WHERE sdt=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, sodienthoai);
			rs = statement.executeQuery();
			while (rs.next()) {
				ketQua = true;
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			// TODO Auto-generated catch block
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
		return ketQua;
	}

	public admin seclectByTenDangNhapVaMatKhau(admin t) {
		try {
			connection = MySQLConnecttion.getConnection();
			String sql = "SELECT * FROM btl_qlcf.admin where taikhoan=?  and matkhau=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, t.getTaikhoan());
			statement.setString(2, t.getMatkhau());
			rs = statement.executeQuery();
			while (rs.next()) {
				admin adminrepository = new admin();
				adminrepository.setMaadmin(rs.getInt("maadmin"));
				adminrepository.setTaikhoan(rs.getString("taikhoan"));
				adminrepository.setMatkhau(rs.getString("matkhau"));
				adminrepository.setHoten(rs.getString("hoten"));
				adminrepository.setSdt(rs.getString("sdt"));
				adminrepository.setAvatar(rs.getBytes("avatar"));
				return adminrepository;
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			// TODO Auto-generated catch block
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

	public boolean changMatKhau(admin userrepository) {
		int ketqua = 0;
		try {
			connection = MySQLConnecttion.getConnection();
			String query = "UPDATE btl_qlcf.admin " + " SET " + " matkhau =? where maadmin=? ";
			statement = connection.prepareStatement(query);
			statement.setString(1, userrepository.getMatkhau());
			statement.setInt(2, userrepository.getMaadmin());
			ketqua = statement.executeUpdate();

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
		return ketqua > 0;

	}
//	public int delete(admin t) {
//		int ketQua = 0;
//		try {
//			connection = MySQLConnecttion.getConnection();
//			String query = "DELETE from btl_qlcf.admin " + " WHERE maadmin=?";
//			statement = connection.prepareStatement(query);
//			statement.setInt(2, t.getMaadmin());
//			ketQua = statement.executeUpdate();
//
//		} catch (SQLException e) {
//			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
//			e.printStackTrace();
//		} finally {
//			try {
//				connection.close();
//				statement.close();
//			} catch (SQLException e) {
//				System.out.println("Lỗi đóng kết nối");
//				e.printStackTrace();
//			}
//		}
//		return ketQua;
//	}
//	public int update(admin t) {
//		int ketQua = 0;
//		try {
//			connection = MySQLConnecttion.getConnection();
//			String query = "UPDATE btl_qlcf.admin " + " SET "  +"hoten=?" + ", gioitinh=?"
//					+ ", diachi=?" + ", diachimuahang=?" + ", diachinhanhang=?" + ", ngaysinh=?" + ", sodienthoai=?"
//					+ ", email=?" + ", dangkinhanemail=?" + " WHERE makhachhang=?";
//
//			statement = connection.prepareStatement(query);
//			st.setString(1, t.getTenDangNhap());
//			st.setString(2, t.getMatKhau());
//			st.setString(3, t.getHoVaTen());
//			st.setString(4, t.getGioiTinh());
//			st.setString(5, t.getDiaChi());
//			st.setString(6, t.getDiaChiMuaHang());
//			st.setString(7, t.getDiaChiNhanHang());
//			st.setDate(8, t.getNgaySinh());
//			st.setString(9, t.getSoDienThoai());
//			st.setString(10, t.getEmail());
//			System.out.println(sql);
//			ketQua = statement.executeUpdate();
//
//		} catch (SQLException e) {
//			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
//			e.printStackTrace();
//		} finally {
//			try {
//				connection.close();
//				statement.close();
//			} catch (SQLException e) {
//				System.out.println("Lỗi đóng kết nối");
//				e.printStackTrace();
//			}
//		}
//		return ketQua;
//	}

	
}
