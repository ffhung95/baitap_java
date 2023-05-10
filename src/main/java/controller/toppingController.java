package controller;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import model.hangHoa;
import model.oderItem;
import repository.hangHoaRepository;
import view.trangChu.toppingView;

public class toppingController {
	 hangHoaRepository foodItemDao = new hangHoaRepository();
	    DecimalFormat formatter = new DecimalFormat("###,###,###");
	    JFrame previousView;

	    interface Event {

	        public abstract void onSelect(oderItem item);
	    }

	    public void add(toppingView view, hangHoa foodItem, Event event) {
	        if (previousView != null && previousView.isDisplayable()) {
	            previousView.requestFocus();
	            return;
	        }
	        previousView = view;
	        view.setVisible(true);
	        view.getLbFoodName().setText(foodItem.getTenHangHoa());
	        view.getSpnFoodPrice().setValue(foodItem.getGiaHangHoa());
	        try {
	            //Hiện danh sách topping
	            for (hangHoa topping : foodItemDao.getByIdCategory(4)) {
	                view.getCboTopping().addItem(topping);
	            }
	            //Ẩn topping nếu k phải trà sữa
	            if (foodItem.getIdmaloaihang() != 2) {
	                view.getLbTopping().setVisible(false);
	                view.getCboTopping().setVisible(false);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        updateAmount(view);
	        view.getBtnOK().addActionListener(evt -> {
	            event.onSelect(addItem(foodItem, view));
	            view.dispose();
	        });
	        view.getBtnCancel().addActionListener(evt -> {
	            view.dispose();
	        });
	        view.getSpnFoodPrice().addChangeListener(evt -> {
	            updateAmount(view);
	        });
	        view.getSpnQuantity().addChangeListener(evt -> {
	            updateAmount(view);
	        });
	        view.getCboTopping().addActionListener(evt -> {
	            updateAmount(view);
	        });
	    }

	    private void updateAmount(toppingView view) {
	        int amount = (int) view.getSpnFoodPrice().getValue();
	        hangHoa topping = (hangHoa) view.getCboTopping().getSelectedItem();
	        if (topping != null) {
	            amount += topping.getGiaHangHoa();
	        }
	        int quantity = (int) view.getSpnQuantity().getValue();
	        amount *= quantity;
	        view.getLbAmount().setText(formatter.format(amount));
	    }

	    public oderItem addItem(hangHoa foodItem, toppingView view) {
	    	oderItem orderItem = new oderItem();
	        try {
	            orderItem.setFoodItem(foodItem);
	            orderItem.setWaterPrice((int) view.getSpnFoodPrice().getValue());
	            if (foodItem.getIdmaloaihang() == 2) {
	                orderItem.setToppingItem((hangHoa) view.getCboTopping().getSelectedItem());
	                orderItem.setToppingPrice((int)orderItem.getToppingItem().getGiaHangHoa());
	            } else {
	                orderItem.setToppingItem(foodItemDao.get(1));
	                orderItem.setToppingPrice(0);
	            }
	            orderItem.setSoluong((int) view.getSpnQuantity().getValue());

	            return orderItem;
	        } catch (Exception e) {
	            return orderItem;
	        }
	    }
}
