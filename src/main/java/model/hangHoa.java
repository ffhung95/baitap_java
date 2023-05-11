package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
public class hangHoa {
private int maHangHoa ,idmaloaihang,idNV;
private String tenHangHoa;
private double giaHangHoa;
private int soLuong;
private loaiHang maLoaiHang;
private nhanVienModel maNhanVien;
private String anhHangHoa;

public hangHoa() {
	super();
}






public hangHoa(int maHangHoa, int idmaloaihang, int idNV, String tenHangHoa, double giaHangHoa, int soLuong,
		loaiHang maLoaiHang, nhanVienModel maNhanVien, String anhHangHoa) {
	super();
	this.maHangHoa = maHangHoa;
	this.idmaloaihang = idmaloaihang;
	this.idNV = idNV;
	this.tenHangHoa = tenHangHoa;
	this.giaHangHoa = giaHangHoa;
	this.soLuong = soLuong;
	this.maLoaiHang = maLoaiHang;
	this.maNhanVien = maNhanVien;
	this.anhHangHoa = anhHangHoa;
}

public String getAnhHangHoa() {
	return anhHangHoa;
}
public void setAnhHangHoa(String anhHangHoa) {
	this.anhHangHoa = anhHangHoa;
}

public int getIdmaloaihang() {
	return idmaloaihang;
}
public void setIdmaloaihang(int idmaloaihang) {
	this.idmaloaihang = idmaloaihang;
}
public int getIdNV() {
	return idNV;
}
public void setIdNV(int idNV) {
	this.idNV = idNV;
}

public int getMaHangHoa() {
	return maHangHoa;
}

public void setMaHangHoa(int maHangHoa) {
	this.maHangHoa = maHangHoa;
}

public String getTenHangHoa() {
	return tenHangHoa;
}

public void setTenHangHoa(String tenHangHoa) {
	this.tenHangHoa = tenHangHoa;
}

public double getGiaHangHoa() {
	return giaHangHoa;
}

public void setGiaHangHoa(double giaHangHoa) {
	this.giaHangHoa = giaHangHoa;
}

public int getSoLuong() {
	return soLuong;
}

public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}

public loaiHang getMaLoaiHang() {
	return maLoaiHang;
}

public void setMaLoaiHang(loaiHang maLoaiHang) {
	this.maLoaiHang = maLoaiHang;
	this.idmaloaihang=maLoaiHang.getMaLoaiang();
}

public nhanVienModel getMaNhanVien() {
	return maNhanVien;
}

public void setMaNhanVien(nhanVienModel maNhanVien) {
	this.maNhanVien = maNhanVien;
	this.idNV=maNhanVien.getManv();
}

@Override
public int hashCode() {
	return Objects.hash(giaHangHoa, maHangHoa, maLoaiHang, maNhanVien, soLuong, tenHangHoa);
}
public static hangHoa getFromResultSet(ResultSet rs) throws SQLException {
	hangHoa f = new hangHoa();
    f.setMaHangHoa(rs.getInt("mahanghoa"));
    f.setTenHangHoa(rs.getNString("tenhanghoa"));
    f.setGiaHangHoa(rs.getInt("giahanghoa"));
    f.setSoLuong(rs.getInt("soluong"));
    f.setIdmaloaihang(rs.getInt("maloaihang"));
    f.setAnhHangHoa(rs.getString("anhhanghoa"));
    return f;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	hangHoa other = (hangHoa) obj;
	return Double.doubleToLongBits(giaHangHoa) == Double.doubleToLongBits(other.giaHangHoa)
			&& maHangHoa == other.maHangHoa && Objects.equals(maLoaiHang, other.maLoaiHang)
			&& Objects.equals(maNhanVien, other.maNhanVien) && soLuong == other.soLuong
			&& Objects.equals(tenHangHoa, other.tenHangHoa);
}

@Override
public String toString() {
	return "hangHoa [maHangHoa=" + maHangHoa + ", tenHangHoa=" + tenHangHoa + ", giaHangHoa=" + giaHangHoa
			+ ", soLuong=" + soLuong + ", maLoaiHang=" + maLoaiHang + ", maNhanVien=" + maNhanVien + "]";
}
}
