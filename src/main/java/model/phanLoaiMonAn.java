package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class phanLoaiMonAn extends Model {
	protected int id;
	protected String name;

	
	public phanLoaiMonAn() {
		super();
	}

	public phanLoaiMonAn(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object[] toRowTable() {
		// TODO Auto-generated method stub
		return new Object[] {
			this.getId(), this.getName()
		};
	}
	 public static phanLoaiMonAn getFromResultSet(ResultSet rs) throws SQLException {
		 phanLoaiMonAn fc = new phanLoaiMonAn();
	        fc.setId(rs.getInt("id"));
	        fc.setName(rs.getNString("name"));
	        return fc;
	    }

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		phanLoaiMonAn other = (phanLoaiMonAn) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
	 
}
