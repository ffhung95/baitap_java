package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.hangHoa;

public class hangHoaRepository extends DAO<hangHoa> {
	@Override
	public ArrayList<hangHoa> getAll() throws SQLException {
		 ArrayList<hangHoa> foodItems = new ArrayList<>();
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM hanghoa ORDER BY maloaihang ASC , tenhanghoa ASC";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	hangHoa foodItem = hangHoa.getFromResultSet(rs);
	            foodItems.add(foodItem);
	        }
	        return foodItems;
	}
	  public ArrayList<hangHoa> getByIdCategory(int id) throws SQLException {
	        ArrayList<hangHoa> foodItems = new ArrayList<>();
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM hanghoa WHERE maloaihang = " + id;
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	hangHoa foodItem = hangHoa.getFromResultSet(rs);
	            foodItems.add(foodItem);
	        }
	        return foodItems;
	    }

	@Override
	public hangHoa get(int id) throws SQLException {
		Statement statement = conn.createStatement();
        String query = "SELECT * FROM food_item WHERE mahanghoa = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
        	hangHoa foodItem = hangHoa.getFromResultSet(rs);
            return foodItem;
        }
        return null;
	}
	@Override
	public void deleteById(int id) throws SQLException {
		 PreparedStatement stmt = conn.prepareStatement("DELETE FROM hanghoa WHERE mahanghoa = ?");
	        stmt.setInt(1, id);
	        stmt.executeUpdate();
		
	}

	@Override
	public void save(hangHoa t) throws SQLException {
		   if (t == null) {
	            throw new SQLException("Food item rỗng");
	        }
	        String query = "INSERT INTO hanghoa (tenhanghoa, giahanghoa, soluong, maloaihang, manv, anhhanghoa) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setNString(1, t.getTenHangHoa());
	        stmt.setDouble(2, t.getGiaHangHoa());
	        stmt.setInt(3, t.getSoLuong());
	        stmt.setInt(4, t.getIdmaloaihang());
	        stmt.setInt(5, t.getIdNV());
	        stmt.setString(6, t.getAnhHangHoa());
	        int row = stmt.executeUpdate();
		
	}

	@Override
	public void update(hangHoa t) throws SQLException {
		 if (t == null) {
	            throw new SQLException("Food item rỗng");
	        }
	        String query = "UPDATE hanghoa SET tenhanghoa = ?, giahanghoa = ?, soluong = ?, maloaihang = ?, manv = ?, anhhanghoa = ? WHERE mahanghoa = ?";
	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setNString(1, t.getTenHangHoa());
	        stmt.setDouble(2, t.getGiaHangHoa());
	        stmt.setInt(3, t.getSoLuong());
	        stmt.setInt(4, t.getIdmaloaihang());
	        stmt.setInt(5, t.getIdNV());
	        stmt.setString(6, t.getAnhHangHoa());
	        stmt.setInt(7, t.getMaHangHoa());
	        int row = stmt.executeUpdate();
		
	}

	@Override
	public void delete(hangHoa t) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM hanghoa WHERE mahanghoa= ?");
        stmt.setInt(1, t.getMaHangHoa());
        stmt.executeUpdate();
		
	}
	 public ArrayList<hangHoa> searchByKey(String key, String word) throws SQLException {
	        ArrayList<hangHoa> fooditems = new ArrayList<>();
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM hanghoa WHERE " + key + " LIKE '%" + word + "%';";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	hangHoa fooditem = hangHoa.getFromResultSet(rs);
	            fooditems.add(fooditem);
	        }
	        return fooditems;
	    }
	 public hangHoa getRandom() throws SQLException {
	        Statement statement = conn.createStatement();
	        String query = "SELECT * FROM hanghoa WHERE maloaihang != 4 ORDER BY RAND() LIMIT 1";
	        ResultSet rs = statement.executeQuery(query);
	        if (rs.next()) {
	        	hangHoa foodItem = hangHoa.getFromResultSet(rs);
	            return foodItem;
	        }
	        return null;
	    }

}
