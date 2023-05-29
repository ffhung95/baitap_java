package model;

import utils.TableStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DatHang {
	private int  maDatHang,soLuong;
	private float thanhTien;
	private hangHoa hanghoa;
	private PhienLamViec nhanvien;
	private table ban;
	
	public DatHang() {
		super();
	}

	public DatHang(int maDatHang, int soLuong, float thanhTien,
			hangHoa hanghoa, PhienLamViec nhanvien, table ban) {
		super();
		this.maDatHang = maDatHang;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
		this.hanghoa = hanghoa;

		this.ban = ban;
	}

	public int getMaDatHang() {
		return maDatHang;
	}

	public void setMaDatHang(int maDatHang) {
		this.maDatHang = maDatHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	public hangHoa getHanghoa() {
		return hanghoa;
	}

	public void setHanghoa(hangHoa hanghoa) {
		this.hanghoa = hanghoa;
	}

	public PhienLamViec  getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(PhienLamViec nhanvien) {
		this.nhanvien = nhanvien;
	}

	public table getBan() {
		return ban;
	}

	public void setBan(table ban) {
		this.ban = ban;
	}
	public static DatHang getFromResultSet(ResultSet rs) throws SQLException {
		DatHang f = new DatHang();
		table bantam = new table();
		bantam.setMaBan(rs.getInt("maban"));
		bantam.setName(rs.getString("name"));
		bantam.setTrangthai(TableStatus.getById(rs.getString("status")));

		PhienLamViec phienLamViec = new PhienLamViec();
		phienLamViec.setMaPhienLamViec(rs.getInt("maphienlamviec"));

		hangHoa hanghoa = new hangHoa();
		hanghoa.setMaHangHoa(rs.getInt("mahanghoa"));
		hanghoa.setTenHangHoa(rs.getNString("tenhanghoa"));

	    f.setMaDatHang(rs.getInt("madathang"));
	    f.setBan(bantam);
		f.setNhanvien(phienLamViec);
		f.setHanghoa(hanghoa);
	    f.setSoLuong(rs.getInt("soluong"));
	    f.setThanhTien(rs.getFloat("thanhtien"));
	    return f;
	}
	
	
}
