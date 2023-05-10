package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import utils.TableStatus;

public class table extends Model {
	protected int maBan;
	protected String name;
	protected TableStatus trangthai;

public table() {
	super();
}
public table(int maBan, String name, TableStatus trangthai) {
	super();
	this.maBan = maBan;
	this.name = name;
	this.trangthai = trangthai;
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getMaBan() {
	return maBan;
}
public void setMaBan(int maBan) {
	this.maBan = maBan;
}


public TableStatus getTrangthai() {
	return trangthai;
}
public void setTrangthai(TableStatus trangthai) {
	this.trangthai = trangthai;
}
public static table getFromResultSet(ResultSet rs) throws SQLException {
	table f = new table();
    f.setMaBan(rs.getInt("maban"));
    f.setName(rs.getString("name"));
   f.setTrangthai(TableStatus.getById(rs.getString("status")));
    return f;
}

@Override
public Object[] toRowTable() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String toString() {
	return "table [maBan=" + maBan + ", name=" + name + ", status=" + trangthai + "]";
}

}
