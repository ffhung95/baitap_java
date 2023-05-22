package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
public class DatHang extends Model{
private int id , idNV ,idBan;
private Timestamp orderTime ,payTime;
private int discount , total;
private nhanVienModel nhanvien;
private table ban;

public DatHang() {
	super();
}

public DatHang(int id, int idNV, int idBan, Timestamp orderTime, Timestamp payTime, int discount, int total,
		nhanVienModel nhanvien, table ban) {
	super();
	this.id = id;
	this.idNV = idNV;
	this.idBan = idBan;
	this.orderTime = orderTime;
	this.payTime = payTime;
	this.discount = discount;
	this.total = total;
	this.nhanvien = nhanvien;
	this.ban = ban;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getIdNV() {
	return idNV;
}

public void setIdNV(int idNV) {
	this.idNV = idNV;
}

public int getIdBan() {
	return idBan;
}

public void setIdBan(int idBan) {
	this.idBan = idBan;
}

public Timestamp getOrderTime() {
	return orderTime;
}

public void setOrderTime(Timestamp orderTime) {
	this.orderTime = orderTime;
}

public Timestamp getPayTime() {
	return payTime;
}

public void setPayTime(Timestamp payTime) {
	this.payTime = payTime;
}

public int getDiscount() {
	return discount;
}

public void setDiscount(int discount) {
	this.discount = discount;
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}

public nhanVienModel getNhanvien() {
	return nhanvien;
}

public void setNhanvien(nhanVienModel nhanvien) {
	this.nhanvien = nhanvien;
}

public table getBan() {
	return ban;
}

public void setBan(table ban) {
	this.ban = ban;
}
public int thanhtoan() {
	return this.total - this.total*this.discount/100;
}
public static DatHang getFromResultSet(ResultSet rs) throws SQLException {
	DatHang o = new DatHang();
    o.setId(rs.getInt("id"));
    o.setIdBan(rs.getInt("idban"));
    o.setOrderTime(rs.getTimestamp("orderDate"));
    o.setPayTime(rs.getTimestamp("payDate"));
    o.setTotal(rs.getInt("total"));
    o.setDiscount(rs.getInt("discount"));
    return o;
}

@Override
public String toString() {
	return "datHang [id=" + id + ", idNV=" + idNV + ", idBan=" + idBan + ", orderTime=" + orderTime + ", payTime="
			+ payTime + ", discount=" + discount + ", total=" + total + ", nhanvien=" + nhanvien + ", ban=" + ban + "]";
}

@Override
public Object[] toRowTable() {
	// TODO Auto-generated method stub
	return new Object[] {
			
	};
}

}
