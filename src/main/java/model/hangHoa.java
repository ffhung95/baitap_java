package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
public class hangHoa {
private int maHangHoa ;
private String tenLoaiHang;
private String tenHangHoa;
private float giaHangHoa;
private int soLuong;
private loaiHang maLoaiHang;
private byte[] anhHangHoa;

public hangHoa() {
	super();
}


public hangHoa(int maHangHoa, String tenLoaiHang, String tenHangHoa, float giaHangHoa, int soLuong, loaiHang maLoaiHang,
		byte[] anhHangHoa) {
	super();
	this.maHangHoa = maHangHoa;
	this.tenLoaiHang = tenLoaiHang;
	this.tenHangHoa = tenHangHoa;
	this.giaHangHoa = giaHangHoa;
	this.soLuong = soLuong;
	this.maLoaiHang = maLoaiHang;
	this.anhHangHoa = anhHangHoa;
}


public byte[] getAnhHangHoa() {
	return anhHangHoa;
}
public void setAnhHangHoa(byte[] anhHangHoa) {
	this.anhHangHoa = anhHangHoa;
}

public String getTenLoaiHang() {
	return tenLoaiHang;
}
public void setTenLoaiHang(String tenLoaiHang) {
	this.tenLoaiHang = tenLoaiHang;
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


public float getGiaHangHoa() {
	return giaHangHoa;
}


public void setGiaHangHoa(float giaHangHoa) {
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
	this.tenLoaiHang=maLoaiHang.getTenLoaiHang();
}


@Override
public int hashCode() {
	return Objects.hash(giaHangHoa, maHangHoa, maLoaiHang,  soLuong, tenHangHoa);
}
public static hangHoa getFromResultSet(ResultSet rs) throws SQLException {
	hangHoa f = new hangHoa();
    f.setMaHangHoa(rs.getInt("mahanghoa"));
    f.setTenHangHoa(rs.getNString("tenhanghoa"));
    f.setGiaHangHoa(rs.getInt("giahanghoa"));
    f.setSoLuong(rs.getInt("soluong"));
    f.setTenLoaiHang(rs.getString("tenloaihang"));
    f.setAnhHangHoa(rs.getBytes("anhhanghoa"));
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
			
			&& Objects.equals(tenHangHoa, other.tenHangHoa);
}

@Override
public String toString() {
	return "hangHoa [maHangHoa=" + maHangHoa + ", tenHangHoa=" + tenHangHoa + ", giaHangHoa=" + giaHangHoa
			+ ", soLuong=" + soLuong + ", maLoaiHang=" + maLoaiHang  + "]";
}
}
