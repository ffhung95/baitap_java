package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatHang {
	private int  maDatHang,maHangHoa,maNhanVien,soLuong,maBan;
	private float thanhTien;
	private hangHoa hanghoa;
	private nhanVienModel nhanvien;
	private table ban;
	
	public DatHang() {
		super();
	}

	public DatHang(int maDatHang, int maHangHoa, int maNhanVien, int soLuong, int maBan, float thanhTien,
			hangHoa hanghoa, nhanVienModel nhanvien, table ban) {
		super();
		this.maDatHang = maDatHang;
		this.maHangHoa = maHangHoa;
		this.maNhanVien = maNhanVien;
		this.soLuong = soLuong;
		this.maBan = maBan;
		this.thanhTien = thanhTien;
		this.hanghoa = hanghoa;
		this.nhanvien = nhanvien;
		this.ban = ban;
	}

	public int getMaDatHang() {
		return maDatHang;
	}

	public void setMaDatHang(int maDatHang) {
		this.maDatHang = maDatHang;
	}

	public int getMaHangHoa() {
		return maHangHoa;
	}

	public void setMaHangHoa(int maHangHoa) {
		this.maHangHoa = maHangHoa;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getMaBan() {
		return maBan;
	}

	public void setMaBan(int maBan) {
		this.maBan = maBan;
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
		this.maHangHoa=hanghoa.getMaHangHoa();
	}

	public nhanVienModel getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(nhanVienModel nhanvien) {
		this.nhanvien = nhanvien;
		this.maNhanVien= nhanvien.getManv();
	}

	public table getBan() {
		return ban;
	}

	public void setBan(table ban) {
		this.ban = ban;
		this.maBan=ban.getMaBan();
	}
	public static DatHang getFromResultSet(ResultSet rs) throws SQLException {
		DatHang f = new DatHang();
	    f.setMaDatHang(rs.getInt("madathang"));
	    f.setMaBan(rs.getInt("maban"));
	    f.setMaNhanVien(rs.getInt("manv"));
	    f.setMaHangHoa(rs.getInt("mahanghoa"));
	    f.setSoLuong(rs.getInt("soluong"));
	    f.setThanhTien(rs.getFloat("thanhtien"));
	    return f;
	}
	
	
}
