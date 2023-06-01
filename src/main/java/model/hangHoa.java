package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
public class hangHoa extends Model{
private int maHangHoa ;
private String tenHangHoa;
private float giaHangHoa;
private int soLuong;
private Admin dmin;
private loaiHang LoaiHang;
private byte[] anhHangHoa;

public hangHoa() {
	super();
}

public hangHoa(int maHangHoa,  String tenHangHoa, float giaHangHoa, int soLuong, Admin dmin,
		loaiHang loaiHang, byte[] anhHangHoa) {
	super();
	this.maHangHoa = maHangHoa;
	this.tenHangHoa = tenHangHoa;
	this.giaHangHoa = giaHangHoa;
	this.soLuong = soLuong;
	this.dmin = dmin;
	LoaiHang = loaiHang;
	this.anhHangHoa = anhHangHoa;
}

public byte[] getAnhHangHoa() {
	return anhHangHoa;
}
public void setAnhHangHoa(byte[] anhHangHoa) {
	this.anhHangHoa = anhHangHoa;
}

public loaiHang getLoaiHang() {
	return LoaiHang;
}

public void setLoaiHang(loaiHang loaiHang) {
	LoaiHang = loaiHang;
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
}

public static hangHoa getFromResultSet(ResultSet rs) throws SQLException {
	loaiHang phanloai = new loaiHang();
	phanloai.setMaloaihang(rs.getInt("maloaihang"));
	phanloai.setTenLoaiHang(rs.getNString("tenloaihang"));

	Admin adminrepository = new Admin();
	adminrepository.setMaadmin(rs.getInt("maadmin"));
	adminrepository.setHoten(rs.getString("hoten"));
	hangHoa f = new hangHoa();
    f.setMaHangHoa(rs.getInt("mahanghoa"));
    f.setTenHangHoa(rs.getNString("tenhanghoa"));
    f.setGiaHangHoa(rs.getInt("giahanghoa"));
    f.setSoLuong(rs.getInt("soluong"));
    f.setLoaiHang(phanloai);
    f.setDmin(adminrepository);
    f.setAnhHangHoa(rs.getBytes("anhhanghoa"));
    return f;
}

@Override
public String toString() {
	return "hangHoa [maHangHoa=" + maHangHoa + ", maloaihang=" +LoaiHang.getMaloaihang()  + ", tenHangHoa=" + tenHangHoa
			+ ", giaHangHoa=" + giaHangHoa + ", soLuong=" + soLuong + ", dmin=" + dmin + ", IdAdmin=" +dmin.getMaadmin()
			+ ", LoaiHang=" + LoaiHang + ", anhHangHoa=" + Arrays.toString(anhHangHoa) + "]";
}

	@Override
	public Object[] toRowTable() {
		return new Object[]{
				this.getMaHangHoa(),this.getTenHangHoa(),this.getGiaHangHoa(),this.getSoLuong(),this.getLoaiHang()
			
		};
	}


}
