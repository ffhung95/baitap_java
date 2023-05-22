package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
public class hangHoa {
private int maHangHoa ;
private int maloaihang;
private String tenHangHoa;
private float giaHangHoa;
private int soLuong;
private Admin dmin;
private int IdAdmin;
private loaiHang LoaiHang;
private byte[] anhHangHoa;

public hangHoa() {
	super();
}

public hangHoa(int maHangHoa, int maloaihang, String tenHangHoa, float giaHangHoa, int soLuong, Admin dmin, int idAdmin,
		loaiHang loaiHang, byte[] anhHangHoa) {
	super();
	this.maHangHoa = maHangHoa;
	this.maloaihang = maloaihang;
	this.tenHangHoa = tenHangHoa;
	this.giaHangHoa = giaHangHoa;
	this.soLuong = soLuong;
	this.dmin = dmin;
	IdAdmin = idAdmin;
	LoaiHang = loaiHang;
	this.anhHangHoa = anhHangHoa;
}

public byte[] getAnhHangHoa() {
	return anhHangHoa;
}
public void setAnhHangHoa(byte[] anhHangHoa) {
	this.anhHangHoa = anhHangHoa;
}

public int getMaloaihang() {
	return maloaihang;
}

public void setMaloaihang(int maloaihang) {
	this.maloaihang = maloaihang;
}

public loaiHang getLoaiHang() {
	return LoaiHang;
}

public void setLoaiHang(loaiHang loaiHang) {
	LoaiHang = loaiHang;
	this.maloaihang=loaiHang.getMaloaihang();
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

public Admin getDmin() {
	return dmin;
}

public void setDmin(Admin dmin) {
	this.dmin = dmin;
	this.IdAdmin=dmin.getMaadmin();
}

public int getIdAdmin() {
	return IdAdmin;
}

public void setIdAdmin(int idAdmin) {
	IdAdmin = idAdmin;
}


public static hangHoa getFromResultSet(ResultSet rs) throws SQLException {
	hangHoa f = new hangHoa();
    f.setMaHangHoa(rs.getInt("mahanghoa"));
    f.setTenHangHoa(rs.getNString("tenhanghoa"));
    f.setGiaHangHoa(rs.getInt("giahanghoa"));
    f.setSoLuong(rs.getInt("soluong"));
    f.setMaloaihang(rs.getInt("maloaihang"));
    f.setIdAdmin(rs.getInt("maadmin"));
    f.setAnhHangHoa(rs.getBytes("anhhanghoa"));
    return f;
}

@Override
public String toString() {
	return "hangHoa [maHangHoa=" + maHangHoa + ", maloaihang=" + maloaihang + ", tenHangHoa=" + tenHangHoa
			+ ", giaHangHoa=" + giaHangHoa + ", soLuong=" + soLuong + ", dmin=" + dmin + ", IdAdmin=" + IdAdmin
			+ ", LoaiHang=" + LoaiHang + ", anhHangHoa=" + Arrays.toString(anhHangHoa) + "]";
}





}
