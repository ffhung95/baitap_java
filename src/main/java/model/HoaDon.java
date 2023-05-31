package model;

import utils.TableStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HoaDon extends Model{
private int maHoaDon;
private table ban;
private float tongTien;

public HoaDon() {
	super();
}

public HoaDon(int maHoaDon, table ban, float tongTien) {
	super();
	this.maHoaDon = maHoaDon;
	this.ban = ban;
	this.tongTien = tongTien;
}

public int getMaHoaDon() {
	return maHoaDon;
}

public void setMaHoaDon(int maHoaDon) {
	this.maHoaDon = maHoaDon;
}

	public table getBan() {
		return ban;
	}

	public void setBan(table ban) {
		this.ban = ban;
	}

	public float getTongTien() {
	return tongTien;
}

public void setTongTien(float tongTien) {
	this.tongTien = tongTien;
}
public static HoaDon getFromResultSet(ResultSet rs) throws SQLException {
	table bantam= new table();
	bantam.setMaBan(rs.getInt("ban.maban"));
	bantam.setName(rs.getString("ban.name"));
	bantam.setTrangthai(TableStatus.getById(rs.getString("ban.status")));
	HoaDon f = new HoaDon();
    f.setMaHoaDon(rs.getInt("MAHD"));
    f.setBan(bantam);
    f.setTongTien(rs.getFloat("soluong"));
    return f;
}

@Override
public String toString() {
	return "HoaDon [maHoaDon=" + maHoaDon + ", maBan=" + ban.getMaBan() + ", ban=" + ban + ", tongTien=" + tongTien + "]";
}

	@Override
	public Object[] toRowTable() {
		return new Object[]{
				this.getMaHoaDon(),this.getBan().getName(),this.getTongTien()
		};
	}

}
