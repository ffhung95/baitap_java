//package repository;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import model.oderItem;
//
//public class oderItemRepository extends DAO<oderItem>{
//	 hangHoaRepository HangHoaRepository = new hangHoaRepository();
//	@Override
//	public ArrayList<oderItem> getAll() throws SQLException {
//		 ArrayList<oderItem> orderItems = new ArrayList<>();
//	        Statement statement = conn.createStatement();
//	        String query = "SELECT * FROM orderitem ORDER BY id DESC, soluong DESC";
//	        ResultSet rs = statement.executeQuery(query);
//	        while (rs.next()) {
//	        	oderItem orderItem = oderItem.getFromResultSet(rs);
//	            orderItem.setFoodItem(HangHoaRepository.get(orderItem.getIdWater()));
//	            orderItem.setToppingItem(HangHoaRepository.get(orderItem.getIdTopping()));
//	            orderItems.add(orderItem);
//	        }
//	        return orderItems;
//	}
//
//	@Override
//	public oderItem get(int id) throws SQLException {
//		  throw new UnsupportedOperationException("Not supported yet.");
//	}
//
//	@Override
//	public void save(oderItem t) throws SQLException {
//		 if (t == null) {
//	            throw new SQLException("Order Item rỗng");
//	        }
//	        String query = "INSERT INTO orderitem(id, idwater, idTopping, soluong, waterPrice, toppingPrice, note) VALUES (?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE  soluong = ?";
//	        PreparedStatement stmt = conn.prepareStatement(query);
//	        stmt.setInt(1, t.getId());
//	        stmt.setInt(2, t.getIdWater());
//	        stmt.setInt(3, t.getIdTopping());
//	        stmt.setInt(4, t.getSoluong());
//	        stmt.setInt(5, t.getWaterPrice());
//	        stmt.setInt(6, t.getToppingPrice());
//	        stmt.setNString(7, t.getNote());
//	        stmt.setInt(8, t.getSoluong());
//	        stmt.executeUpdate();
//		
//	}
//
//	@Override
//	public void update(oderItem t) throws SQLException {
//		  if (t == null) {
//	            throw new SQLException("Order Item rỗng");
//	        }
//	        String query = "UPDATE orderitem SET  soluong = ?, waterPrice = ?, toppingPrice = ?, note = ? WHERE id = ? AND idwater = ? AND idTopping = ?";
//	        PreparedStatement stmt = conn.prepareStatement(query);
//	        stmt.setInt(1, t.getSoluong());
//	        stmt.setInt(2, t.getWaterPrice());
//	        stmt.setInt(3, t.getToppingPrice());
//	        stmt.setNString(4, t.getNote());
//	        stmt.setInt(5, t.getId());
//	        stmt.setInt(6, t.getIdWater());
//	        stmt.setInt(7, t.getIdTopping());
//	        stmt.executeUpdate();
//		
//	}
//
//	@Override
//	public void delete(oderItem t) throws SQLException {
//		  if (t == null) {
//	            throw new SQLException("Order Item rỗng");
//	        }
//	        PreparedStatement stmt = conn.prepareStatement("DELETE FROM orderitem WHERE id = ? AND idwater = ? AND idTopping = ?");
//	        stmt.setInt(1, t.getId());
//	        stmt.setInt(2, t.getIdWater());
//	        stmt.setInt(3, t.getIdTopping());
//	        stmt.executeUpdate();
//	}
//
//	@Override
//	public void deleteById(int id) throws SQLException {
//		throw new UnsupportedOperationException("Not supported yet.");
//		
//	}
//
//    public void addItem(oderItem t) throws SQLException {
//        if (t == null) {
//            throw new SQLException("Order Item rỗng");
//        }
//        String query = "CALL `addOrderItem`(?, ?, ?, ?, ?)";
//        PreparedStatement stmt = conn.prepareStatement(query);
//        stmt.setInt(1, t.getId());
//        stmt.setInt(2, t.getIdWater());
//        stmt.setInt(3, t.getIdTopping());
//        stmt.setInt(4, t.getSoluong());
//        stmt.setNString(5, t.getNote());
//    }
//    public ArrayList<oderItem> getByIdOrder(int idOrder) throws SQLException {
//        ArrayList<oderItem> orderItems = new ArrayList<>();
//        Statement statement = conn.createStatement();
//        String query = "SELECT * FROM orderitem WHERE id = " + idOrder + "  ORDER BY soluong DESC";
//        ResultSet rs = statement.executeQuery(query);
//        while (rs.next()) {
//        	oderItem orderItem = oderItem.getFromResultSet(rs);
//            orderItem.setFoodItem(HangHoaRepository.get(orderItem.getIdWater()));
//            orderItem.setToppingItem(HangHoaRepository.get(orderItem.getIdTopping()));
//            orderItems.add(orderItem);
//        }
//        return orderItems;
//    }
//    public ArrayList<oderItem> searchByKey(String key, String word) throws SQLException {
//        ArrayList<oderItem> orderitems = new ArrayList<>();
//        Statement statement = conn.createStatement();
//        String query = "SELECT * FROM orderitem WHERE " + key + " LIKE '%" + word + "%';";
//        ResultSet rs = statement.executeQuery(query);
//        while (rs.next()) {
//        	oderItem orderitem = oderItem.getFromResultSet(rs);
//            orderitems.add(orderitem);
//        }
//        return orderitems;
//    }
//
//}
