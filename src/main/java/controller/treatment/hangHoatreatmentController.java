package controller.treatment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import model.hangHoa;
import model.loaiHang;
import repository.hangHoaRepository;
import repository.loaiHangHoaRepository;
import view.order.hangHoaPanel;
import view.order.loaiHangPanel;

public class hangHoatreatmentController {
	 loaiHangHoaRepository foodCategoryDao = new loaiHangHoaRepository();
	    hangHoaRepository foodItemDao = new hangHoaRepository();
	    JPanel panelFoodCategory, panelFoodItem;

	    public interface Event {

	        public abstract void onChange(hangHoa hangHoa);
	    }

	    public hangHoatreatmentController() {
	    }

	    public JPanel getPanelFoodCategory() {
	        return panelFoodCategory;
	    }

	    public void setPanelFoodCategory(JPanel panelFoodCategory) {
	        this.panelFoodCategory = panelFoodCategory;
	    }

	    public JPanel getPanelFoodItem() {
	        return panelFoodItem;
	    }

	    public void setPanelFoodItem(JPanel panelFoodItem) {
	        this.panelFoodItem = panelFoodItem;
	    }

	    public void renderCategory(Event evt) throws Exception {
	        panelFoodCategory.removeAll();
	        renderFoodItem(2, evt);
	        for (loaiHang foodCategory : foodCategoryDao.getAll()) {
	            loaiHangPanel pnl = new loaiHangPanel(foodCategory);
	            panelFoodCategory.add(pnl);
	            pnl.addMouseListener(new MouseAdapter() {
	                @Override
	                public void mousePressed(MouseEvent e) {
	                    loaiHang foodCategory = pnl.getFoodCategory();
	                    try {
	                        renderFoodItem(foodCategory.getTenLoaiHang(), evt);
	                    } catch (Exception ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            });

	        }
	        panelFoodCategory.updateUI();
	    }

	    public void renderFoodItem(String tenCategory, Event event) throws Exception {
	        panelFoodItem.removeAll();
	        for (hangHoa foodItem : foodItemDao.getByIdCategory(tenCategory)) {
	            hangHoaPanel pnl = new hangHoaPanel(foodItem);
	            panelFoodItem.add(pnl);
	            pnl.addMouseListener(new MouseAdapter() {
	                @Override
	                public void mousePressed(MouseEvent e) {
	                    event.onChange(pnl.getFoodItem());
	                }
	            });
	        }
	        panelFoodItem.updateUI();
	    }

}
