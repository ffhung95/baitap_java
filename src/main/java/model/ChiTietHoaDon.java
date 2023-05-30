package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChiTietHoaDon {
private int maChiTietHoaDon, maHoaDon,maNhanVien,maHangHoa , soLuong;
private float thanhTien;
private HoaDon hoaDon;
private nhanVienModel nhanvien;
private hangHoa HangHoa;
private String ghiChu;

public ChiTietHoaDon() {
	super();
}

public ChiTietHoaDon(int maChiTietHoaDon, int maHoaDon, int maNhanVien, int maHangHoa, int soLuong, float thanhTien,
		HoaDon hoaDon, nhanVienModel nhanvien, hangHoa hangHoa, String ghiChu) {
	super();
	this.maChiTietHoaDon = maChiTietHoaDon;
	this.maHoaDon = maHoaDon;
	this.maNhanVien = maNhanVien;
	this.maHangHoa = maHangHoa;
	this.soLuong = soLuong;
	this.thanhTien = thanhTien;
	this.hoaDon = hoaDon;
	this.nhanvien = nhanvien;
	HangHoa = hangHoa;
	this.ghiChu = ghiChu;
}

public int getMaChiTietHoaDon() {
	return maChiTietHoaDon;
}

public void setMaChiTietHoaDon(int maChiTietHoaDon) {
	this.maChiTietHoaDon = maChiTietHoaDon;
}

public int getMaHoaDon() {
	return maHoaDon;
}

public void setMaHoaDon(int maHoaDon) {
	this.maHoaDon = maHoaDon;
}

public int getMaNhanVien() {
	return maNhanVien;
}

public void setMaNhanVien(int maNhanVien) {
	this.maNhanVien = maNhanVien;
}

public int getMaHangHoa() {
	return maHangHoa;
}

public void setMaHangHoa(int maHangHoa) {
	this.maHangHoa = maHangHoa;
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

public HoaDon getHoaDon() {
	return hoaDon;
}

public void setHoaDon(HoaDon hoaDon) {
	this.hoaDon = hoaDon;
	this.maHoaDon=hoaDon.getMaHoaDon();
}

public nhanVienModel getNhanvien() {
	return nhanvien;
}

public void setNhanvien(nhanVienModel nhanvien) {
	this.nhanvien = nhanvien;
	this.maNhanVien=nhanvien.getManv();
}

public hangHoa getHangHoa() {
	return HangHoa;
}

public void setHangHoa(hangHoa hangHoa) {
	HangHoa = hangHoa;
	this.maHangHoa=hangHoa.getMaHangHoa();
}

public String getGhiChu() {
	return ghiChu;
}

public void setGhiChu(String ghiChu) {
	this.ghiChu = ghiChu;
}
public static ChiTietHoaDon getFromResultSet(ResultSet rs) throws SQLException {
	ChiTietHoaDon f = new ChiTietHoaDon();
    f.setMaChiTietHoaDon(rs.getInt("ma_cthd"));
    f.setMaHoaDon(rs.getInt("mahd"));
    f.setMaNhanVien(rs.getInt("manv"));
    f.setMaHangHoa(rs.getInt("mamon"));
    f.setSoLuong(rs.getInt("soluong"));	
    f.setThanhTien(rs.getFloat("THANHTIEN"));
    f.setGhiChu(rs.getString("GHICHU"));
    return f;
}


}
