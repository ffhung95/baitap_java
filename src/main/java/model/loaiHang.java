package model;

import java.sql.ResultSet;
import java.sql.SQLException;
public class loaiHang extends Model{
 private String tenLoaiHang;
 public loaiHang() {
		super();
	}
	 
public loaiHang( String tenLoaiHang) {
	super();
	
	this.tenLoaiHang = tenLoaiHang;
	
}


public String getTenLoaiHang() {
	return tenLoaiHang;
}

public void setTenLoaiHang(String tenLoaiHang) {
	this.tenLoaiHang = tenLoaiHang;
}


public static loaiHang getFromResultSet(ResultSet rs) throws SQLException {
	loaiHang phanloai = new loaiHang();
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
			this.getTenLoaiHang()
	};
}

}
