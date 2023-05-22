package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import utils.NhanVienStatus;
import utils.TableStatus;

public class PhienLamViec {
	protected int maPhienLamViec, maNhanVien;
	protected nhanVienModel nhanvien;
	protected NhanVienStatus trangThai;
	
	public PhienLamViec() {
		super();
	}

	public PhienLamViec(int maPhienLamViec, int maNhanVien, nhanVienModel nhanvien, NhanVienStatus trangThai) {
		super();
		this.maPhienLamViec = maPhienLamViec;
		this.maNhanVien = maNhanVien;
		this.nhanvien = nhanvien;
		this.trangThai = trangThai;
	}
	
	public nhanVienModel getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(nhanVienModel nhanvien) {
		this.nhanvien = nhanvien;
		this.maNhanVien=nhanvien.getManv();
	}

	public int getMaPhienLamViec() {
		return maPhienLamViec;
	}

	public void setMaPhienLamViec(int maPhienLamViec) {
		this.maPhienLamViec = maPhienLamViec;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public NhanVienStatus getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(NhanVienStatus trangThai) {
		this.trangThai = trangThai;
	}

	
	
	public static PhienLamViec getFromResultSet(ResultSet rs) throws SQLException {
		PhienLamViec f = new PhienLamViec();
	    f.setMaPhienLamViec(rs.getInt("maphienlamviec"));
	    f.setMaNhanVien(rs.getInt("manv"));
	   f.setTrangThai(NhanVienStatus.getById(rs.getString("trangthai")));
	    return f;
	}
	
}
