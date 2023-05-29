package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import utils.NhanVienStatus;
import utils.TableStatus;

public class PhienLamViec {
	protected int maPhienLamViec;
	protected nhanVienModel nhanvien;
	protected NhanVienStatus trangThai;
	
	public PhienLamViec() {
		super();
	}

	public PhienLamViec(int maPhienLamViec, nhanVienModel nhanvien, NhanVienStatus trangThai) {
		super();
		this.maPhienLamViec = maPhienLamViec;

		this.nhanvien = nhanvien;
		this.trangThai = trangThai;
	}
	
	public nhanVienModel getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(nhanVienModel nhanvien) {
		this.nhanvien = nhanvien;
	}

	public int getMaPhienLamViec() {
		return maPhienLamViec;
	}

	public void setMaPhienLamViec(int maPhienLamViec) {
		this.maPhienLamViec = maPhienLamViec;
	}

	public NhanVienStatus getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(NhanVienStatus trangThai) {
		this.trangThai = trangThai;
	}

	
	
	public static PhienLamViec getFromResultSet(ResultSet rs) throws SQLException {
		PhienLamViec f = new PhienLamViec();
		nhanVienModel nhanienrepository = new nhanVienModel();
		nhanienrepository.setManv(rs.getInt("manv"));
		nhanienrepository.setHoten(rs.getString("hotennv"));
	    f.setMaPhienLamViec(rs.getInt("maphienlamviec"));
	    f.setNhanvien(nhanienrepository);
	   	f.setTrangThai(NhanVienStatus.getById(rs.getString("trangthai")));
	    return f;
	}
	
}
