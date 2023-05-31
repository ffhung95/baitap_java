package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

public class Admin extends Model {
	private int maadmin;
	private String taikhoan;
	private String matkhau;
	private String hoten;
	private String sdt;
	byte[] avatar;
	
	public Admin() {
		super();
	}
	public Admin(int maadmin, String taikhoan, String matkhau, String hoten, String sdt, byte[] avatar) {
		super();
		this.maadmin = maadmin;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		this.hoten = hoten;
		this.sdt = sdt;
		this.avatar = avatar;
	}
	public int getMaadmin() {
		return maadmin;
	}
	public void setMaadmin(int maadmin) {
		this.maadmin = maadmin;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public byte[] getAvatar() {
		return avatar;
	}
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	@Override
	public String toString() {
		return hoten ;
	}

	@Override
	public Object[] toRowTable() {
		return new Object[]{
				this.getMaadmin(),this.getTaikhoan(),this.getMatkhau(),this.getHoten(),
				this.getSdt(),this.getAvatar()
		};
	}

	public static Admin getFromResultSet(ResultSet rs) throws SQLException {
		Admin adminrepository = new Admin();
		adminrepository.setMaadmin(rs.getInt("maadmin"));
		adminrepository.setTaikhoan(rs.getString("taikhoan"));
		adminrepository.setMatkhau(rs.getString("matkhau"));
		adminrepository.setHoten(rs.getString("hoten"));
		adminrepository.setSdt(rs.getString("sdt"));
		adminrepository.setAvatar(rs.getBytes("avatar"));
		return adminrepository;
	}
}
