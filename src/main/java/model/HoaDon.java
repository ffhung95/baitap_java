package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HoaDon {
private int maHoaDon;
private int maBan;
private table ban;
private float tongTien;

public HoaDon() {
	super();
}

public HoaDon(int maHoaDon, int maBan, table ban, float tongTien) {
	super();
	this.maHoaDon = maHoaDon;
	this.maBan = maBan;
	this.ban = ban;
	this.tongTien = tongTien;
}

public int getMaHoaDon() {
	return maHoaDon;
}

public void setMaHoaDon(int maHoaDon) {
	this.maHoaDon = maHoaDon;
}

public int getMaBan() {
	return maBan;
}

public void setMaBan(int maBan) {
	this.maBan = maBan;
}

public table getBan() {
	return ban;
}

public void setBan(table ban) {
	this.ban = ban;
	this.maBan=ban.getMaBan();
}

public float getTongTien() {
	return tongTien;
}

public void setTongTien(float tongTien) {
	this.tongTien = tongTien;
}
public static HoaDon getFromResultSet(ResultSet rs) throws SQLException {
	HoaDon f = new HoaDon();
    f.setMaHoaDon(rs.getInt("MAHD"));
    f.setMaBan(rs.getInt("maban"));
    f.setTongTien(rs.getFloat("soluong"));
    return f;
}

@Override
public String toString() {
	return "HoaDon [maHoaDon=" + maHoaDon + ", maBan=" + maBan + ", ban=" + ban + ", tongTien=" + tongTien + "]";
}


}
