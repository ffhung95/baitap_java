package model;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class nhanVienModel {
private int manv;
private String hoten;
private String taikhoan;
private String matkhau;
private String sdt;
private Date ngayvaolam;
private String chucvu;
private int luong;
public nhanVienModel() {
	super();
}
public nhanVienModel(int manv, String hoten, String taikhoan, String matkhau, String sdt, Date ngayvaolam,
		String chucvu, int luong) {
	super();
	this.manv = manv;
	this.hoten = hoten;
	this.taikhoan = taikhoan;
	this.matkhau = matkhau;
	this.sdt = sdt;
	this.ngayvaolam = ngayvaolam;
	this.chucvu = chucvu;
	this.luong = luong;
	
}

public int getManv() {
	return manv;
}

public void setManv(int manv) {
	this.manv = manv;
}

public String getHoten() {
	return hoten;
}

public void setHoten(String hoten) {
	this.hoten = hoten;
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

public String getSdt() {
	return sdt;
}

public void setSdt(String sdt) {
	this.sdt = sdt;
}

public Date getNgayvaolam() {
	return ngayvaolam;
}

public void setNgayvaolam(Date ngayvaolam) {
	this.ngayvaolam = ngayvaolam;
}

public String getChucvu() {
	return chucvu;
}

public void setChucvu(String chucvu) {
	this.chucvu = chucvu;
}

public int getLuong() {
	return luong;
}

public void setLuong(int luong) {
	this.luong = luong;
}



@Override
public int hashCode() {
	return Objects.hash( hoten, taikhoan,matkhau,sdt, ngayvaolam, chucvu, luong);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	nhanVienModel other = (nhanVienModel) obj;
	return Objects.equals(chucvu, other.chucvu) && Objects.equals(hoten, other.hoten) && luong == other.luong
			&& manv == other.manv && Objects.equals(matkhau, other.matkhau)
			&& Objects.equals(ngayvaolam, other.ngayvaolam) && Objects.equals(sdt, other.sdt)
			&& Objects.equals(taikhoan, other.taikhoan);
}
@Override
public String toString() {
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	return "nhanVienModel [manv=" + manv + ", hoten=" + hoten + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau
			+ ", sdt=" + sdt + ", ngayvaolam=" + sdf.format(ngayvaolam) + ", chucvu=" + chucvu + ", luong=" + luong + ", avatar="
			 + "]";
}

}
