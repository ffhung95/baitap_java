package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class loaiHang extends Model {
	private int maloaihang;
	private String tenLoaiHang;

	public loaiHang() {
		super();
	}
	public loaiHang(int maloaihang, String tenLoaiHang) {
		super();
		this.maloaihang = maloaihang;
		this.tenLoaiHang = tenLoaiHang;
	}
	public int getMaloaihang() {
		return maloaihang;
	}
	public void setMaloaihang(int maloaihang) {
		this.maloaihang = maloaihang;
	}
	public String getTenLoaiHang() {
		return tenLoaiHang;
	}
	public void setTenLoaiHang(String tenLoaiHang) {
		this.tenLoaiHang = tenLoaiHang;
	}
	public static loaiHang getFromResultSet(ResultSet rs) throws SQLException {
		loaiHang phanloai = new loaiHang();
		phanloai.setMaloaihang(rs.getInt("maloaihang"));
		phanloai.setTenLoaiHang(rs.getNString("tenloaihang"));
		return phanloai;
	}

	@Override
	public String toString() {
		return tenLoaiHang;
	}

	@Override
	public Object[] toRowTable() {
		// TODO Auto-generated method stub
		return new Object[] { this.getTenLoaiHang() };
	}

}
