package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Objects;

public class FoodItem extends Model{
	 protected int id;
	    protected String name, description, urlImage, unitName;
	    protected int unitPrice, idCategory;
	    DecimalFormat formatter = new DecimalFormat("###,###,###");
	    
	public FoodItem() {
			super();
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getUrlImage() {
		return urlImage;
	}


	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}


	public String getUnitName() {
		return unitName;
	}


	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}


	public int getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}


	public int getIdCategory() {
		return idCategory;
	}


	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}


	public DecimalFormat getFormatter() {
		return formatter;
	}


	public void setFormatter(DecimalFormat formatter) {
		this.formatter = formatter;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toRowTable() {
		// TODO Auto-generated method stub
		 return new Object[]{
		            this.getId(), this.getName(), this.getDescription(), this.getUrlImage(),
		            this.getUnitName(), this.getUnitPrice(), this.getIdCategory()
		        };
	}
	 public static FoodItem getFromResultSet(ResultSet rs) throws SQLException {
	        FoodItem f = new FoodItem();
	        f.setId(rs.getInt("id"));
	        f.setName(rs.getNString("name"));
	        f.setDescription(rs.getNString("description"));
	        f.setUrlImage(rs.getNString("urlImage"));
	        f.setUnitName(rs.getNString("unitName"));
	        f.setUnitPrice(rs.getInt("unitPrice"));
	        f.setIdCategory(rs.getInt("idCategory"));
	        return f;
	    }


	@Override
	public int hashCode() {
		return Objects.hash(description, formatter, id, idCategory, name, unitName, unitPrice, urlImage);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodItem other = (FoodItem) obj;
		return Objects.equals(description, other.description) && Objects.equals(formatter, other.formatter)
				&& id == other.id && idCategory == other.idCategory && Objects.equals(name, other.name)
				&& Objects.equals(unitName, other.unitName) && unitPrice == other.unitPrice
				&& Objects.equals(urlImage, other.urlImage);
	}
	 

}
