//package controller;
//
//import java.util.ArrayList;
//import javax.swing.JPanel;
//import model.oderItem;
//import view.order.oderItemPanel;
//
//public class orderItemController {
//	  private ArrayList<oderItem> orderItems;
//	    private JPanel panelOrderItem;
//	    private int idOrder;
//
//	    public interface Event {
//
//	        public abstract void onChange();
//	    }
//	    Event onQuantityChange;
//
//	    public orderItemController() {
//	    }
//
//	    public JPanel getPanelOrderItem() {
//	        return panelOrderItem;
//	    }
//
//	    public void setPanelOrderItem(JPanel panelOrderItem) {
//	        this.panelOrderItem = panelOrderItem;
//	    }
//
//	    public int getIdOrder() {
//	        return idOrder;
//	    }
//
//	    public void setIdOrder(int idOrder) {
//	        this.idOrder = idOrder;
//	    }
//
//	    public void renderOrderItem() {
//	        panelOrderItem.removeAll();
//	        for (oderItem orderItem : orderItems) {
//	        	oderItemPanel pane = new oderItemPanel(orderItem);
//	            pane.getSpnQuantity().addChangeListener(evt -> {
//	                orderItem.setSoluong((int) pane.getSpnQuantity().getValue());
//	                if (onQuantityChange != null) {
//	                    onQuantityChange.onChange();// Gọi hàm update amount
//	                }
//	            });
//	            panelOrderItem.add(pane);
//	        }
//	        panelOrderItem.updateUI();
//	    }
//
//	    public ArrayList<oderItem> getOrderItems() {
//	        return orderItems;
//	    }
//
//	    public void setOrderItems(ArrayList<oderItem> orderItems) {
//	        this.orderItems = orderItems;
//	        renderOrderItem();
//	    }
//
//	    public int getTotalAmount() {
//	        int totalAmount = 0;
//	        for (oderItem orderItem : orderItems) {
//	            totalAmount += orderItem.getSoluong();
//	        }
//	        return totalAmount;
//	    }
//
//	    public void addOrderItem(oderItem item) {
//	        if (item == null) {
//	            return;
//	        }
//	        item.setId(idOrder);
//	        for (oderItem orderItem : orderItems) {
//	            if (item.equals(orderItem)) {
//	                orderItem.setSoluong(orderItem.getSoluong() + item.getSoluong());
//	                orderItem.setWaterPrice(item.getWaterPrice());
//	                renderOrderItem();
//	                return;
//	            }
//	        }
//	        orderItems.add(item);
//	        renderOrderItem();
//	    }
//
//	    public void setOnQuantityChange(Event onQuantityChange) {
//	        this.onQuantityChange = onQuantityChange;
//	    }
//}
