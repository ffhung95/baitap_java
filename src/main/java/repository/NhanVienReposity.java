package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import database.MySQLConnecttion;
import model.admin;
import model.nhanVienModel;

public class NhanVienReposity {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	public List<nhanVienModel> getAdmin() {

		List<nhanVienModel> list = new LinkedList<nhanVienModel>();
		try {
			connection = MySQLConnecttion.getConnection();
			String query = "SELECT * FROM btl_qlcf.nhanvien ";
			statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
			while (rs.next()) {
				nhanVienModel nhanienrepository = new nhanVienModel();
				nhanienrepository.setManv(rs.getInt("manv"));
				nhanienrepository.setHoten(rs.getString("hotennv"));
				nhanienrepository.setTaikhoan(rs.getString("taikhoan"));
				nhanienrepository.setMatkhau(rs.getString("matkhau"));
				nhanienrepository.setSdt(rs.getString("sdt"));
				java.sql.Date nagyvaolam = rs.getDate("ngayvaolam");
				if (nagyvaolam != null) {
					nhanienrepository.setNgayvaolam(new Date(nagyvaolam.getTime()));
				}
				nhanienrepository.setChucvu(rs.getString("chucvu"));
				nhanienrepository.setLuong(rs.getInt("luong"));
				list.add(nhanienrepository);
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

	public nhanVienModel selectById(nhanVienModel t) {
		try {
			connection = MySQLConnecttion.getConnection();
			String query = "SELECT * FROM btl_qlcf.nhanvien WHERE manv = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, t.getManv());
			rs = statement.executeQuery();
			while (rs.next()) {
				nhanVienModel nhanienrepository = new nhanVienModel();
				nhanienrepository.setManv(rs.getInt("manv"));
				nhanienrepository.setTaikhoan(rs.getString("taikhoan"));
				nhanienrepository.setMatkhau(rs.getString("matkhau"));
				nhanienrepository.setHoten(rs.getString("hotennv"));
				nhanienrepository.setSdt(rs.getString("sdt"));
				java.sql.Date birthday = rs.getDate("ngayvaolam");
				if (birthday != null) {
					nhanienrepository.setNgayvaolam(new Date(birthday.getTime()));
				}
				nhanienrepository.setChucvu(rs.getString("chucvu"));
				nhanienrepository.setLuong(rs.getInt("luong"));
				return nhanienrepository;
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

	public int insertUser(nhanVienModel kh) {
		int ketqua = 0;
		try {
			connection = MySQLConnecttion.getConnection();
			String query = " INSERT INTO btl_qlcf.nhanvien ( hotennv , taikhoan ,matkhau , sdt ,ngayvaolam ,chucvu ,luong ) "
					+ " VALUES (?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, kh.getHoten());
			statement.setString(2, kh.getTaikhoan());
			statement.setString(3, kh.getMatkhau());
			statement.setString(4, kh.getSdt());
			statement.setDate(5, new java.sql.Date(kh.getNgayvaolam().getTime()));
			statement.setString(6, kh.getChucvu());
			statement.setInt(7, kh.getLuong());
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
			String sql = "SELECT * FROM btl_qlcf.nhanvien WHERE taikhoan=?";
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

	public nhanVienModel seclectByTenDangNhapVaMatKhau(nhanVienModel t) {
		try {
			connection = MySQLConnecttion.getConnection();
			String sql = "SELECT * FROM btl_qlcf.nhanvien where taikhoan=?  and matkhau=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, t.getTaikhoan());
			statement.setString(2, t.getMatkhau());
			rs = statement.executeQuery();
			while (rs.next()) {
				nhanVienModel nhanienrepository = new nhanVienModel();
				nhanienrepository.setManv(rs.getInt("manv"));
				nhanienrepository.setHoten(rs.getString("hotennv"));
				nhanienrepository.setTaikhoan(rs.getString("taikhoan"));
				nhanienrepository.setMatkhau(rs.getString("matkhau"));
				nhanienrepository.setSdt(rs.getString("sdt"));
				java.sql.Date birthday = rs.getDate("ngayvaolam");
				if (birthday != null) {
					nhanienrepository.setNgayvaolam(new Date(birthday.getTime()));
				}
				nhanienrepository.setChucvu(rs.getString("chucvu"));
				nhanienrepository.setLuong(rs.getInt("luong"));
				return nhanienrepository;
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

	public boolean changMatKhau(nhanVienModel userrepository) {
		int ketqua = 0;
		try {
			connection = MySQLConnecttion.getConnection();
			String query = "UPDATE btl_qlcf.nhanvien " + " SET " + " matkhau =? where manv=? ";
			statement = connection.prepareStatement(query);
			statement.setString(1, userrepository.getMatkhau());
			statement.setInt(2, userrepository.getManv());
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

	public boolean kiemTraSoDienThoai(String sodienthoai) {
		boolean ketQua = false;
		try {
			connection = MySQLConnecttion.getConnection();
			String sql = "SELECT * FROM btl_qlcf.nhanvien WHERE sdt=?";
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

	public int delete(nhanVienModel t) {
		int ketQua = 0;
		try {
			connection = MySQLConnecttion.getConnection();
			String sql = "DELETE from btl_qlcf.nhanvien " + " WHERE hotennv=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, t.getHoten());
			ketQua = statement.executeUpdate();
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
		return ketQua;
	}
	public int update(nhanVienModel kh) {
		int ketQua = 0;
		try {
			connection = MySQLConnecttion.getConnection();
			String sql = "UPDATE btl_qlcf.nhanvien " + " SET " +  "  sdt= ? , ngayvaolam=? ,chucvu=? , luong=? "+ " WHERE hotennv=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, kh.getSdt());
			statement.setDate(2, new java.sql.Date(kh.getNgayvaolam().getTime()));
			statement.setString(3, kh.getChucvu());
			statement.setInt(4, kh.getLuong());
			statement.setString(5, kh.getHoten());
			ketQua = statement.executeUpdate();
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
		return ketQua;
	}

}
