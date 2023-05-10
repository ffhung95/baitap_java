package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class oderItem extends Model{
	private int id, idWater, idTopping, soluong, WaterPrice, toppingPrice;
	private String note;
	private hangHoa foodItem, toppingItem;

	public oderItem() {
		soluong = 1;
		idTopping = 0;
		note = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdWater() {
		return idWater;
	}

	public void setIdWater(int idWater) {
		this.idWater = idWater;
	}

	public int getIdTopping() {
		return idTopping;
	}

	public void setIdTopping(int idTopping) {
		this.idTopping = idTopping;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		if(soluong>=0) {
			this.soluong = soluong;
		}
		else {
			this.soluong=0;
		}
	}

	public int getWaterPrice() {
		return WaterPrice;
	}

	public void setWaterPrice(int waterPrice) {
		WaterPrice = waterPrice;
	}

	public int getToppingPrice() {
		return toppingPrice;
	}

	public void setToppingPrice(int toppingPrice) {
		this.toppingPrice = toppingPrice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public hangHoa getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(hangHoa foodItem) {
		this.foodItem = foodItem;
		this.idWater=foodItem.getIdmaloaihang();
	}

	public hangHoa getToppingItem() {
		return toppingItem;
	}

	public void setToppingItem(hangHoa toppingItem) {
		this.toppingItem = toppingItem;
		this.idTopping=toppingItem.getIdmaloaihang();
	}
	 public static oderItem getFromResultSet(ResultSet rs) throws SQLException {
		 oderItem oi = new oderItem();
	        oi.setId(rs.getInt("id"));
	        oi.setIdWater(rs.getInt("idwater"));
	        oi.setIdTopping(rs.getInt("idTopping"));
	        oi.setSoluong(rs.getInt("soluong"));
	        oi.setWaterPrice(rs.getInt("waterPrice"));
	        oi.setToppingPrice(rs.getInt("toppingPrice"));
	        oi.setNote(rs.getNString("note"));
	        return oi;
	    }
	@Override
	public String toString() {
		return "oderItem [id=" + id + ", idWater=" + idWater + ", idTopping=" + idTopping + ", soluong=" + soluong
				+ ", WaterPrice=" + WaterPrice + ", toppingPrice=" + toppingPrice + ", note=" + note + ", foodItem="
				+ foodItem + ", toppingItem=" + toppingItem + "]";
	}

	@Override
	public Object[] toRowTable() {
		 throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
