package model;

import java.sql.ResultSet;
import java.sql.SQLException;
public class loaiHang extends Model{
 private int maLoaiang;
 private String tenLoaiHang;
 public loaiHang() {
		super();
	}
	 
public loaiHang(int maLoaiang, String tenLoaiHang) {
	super();
	this.maLoaiang = maLoaiang;
	this.tenLoaiHang = tenLoaiHang;
	
}

public int getMaLoaiang() {
	return maLoaiang;
}

public void setMaLoaiang(int maLoaiang) {
	this.maLoaiang = maLoaiang;
}

public String getTenLoaiHang() {
	return tenLoaiHang;
}

public void setTenLoaiHang(String tenLoaiHang) {
	this.tenLoaiHang = tenLoaiHang;
}


public static loaiHang getFromResultSet(ResultSet rs) throws SQLException {
	loaiHang phanloai = new loaiHang();
	phanloai.setMaLoaiang(rs.getInt("maloaihang"));
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
	return new Object[] {
			this.getMaLoaiang(),this.getTenLoaiHang()
	};
}
@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final loaiHang other = (loaiHang) obj;
    if (this.maLoaiang != other.maLoaiang) {
        return false;
    }
    return true;
}
}
