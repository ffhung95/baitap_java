package controller;
import javax.swing.JFrame;
import model.loaiHang;
import repository.loaiHangHoaRepository;
import view.trangChu.loaiHangView;
public class loaiHangController {
 loaiHangHoaRepository LoaiHangRepo= new loaiHangHoaRepository();
 JFrame previousView;
 public void add(loaiHangView view) {
     if (previousView != null && previousView.isDisplayable()) {
         previousView.requestFocus();
         return;
     }
     
     previousView = view;
     view.setVisible(true);
     view.getBtnCancel().addActionListener(evt -> view.dispose());
     view.getBtnOK().addActionListener(evt -> {
         try {
             addFoodCategory(view);
             view.dispose();
             view.showMessage("Thêm loại món thành công!");
         } catch (Exception ex) {
        	 ex.printStackTrace();
         }
     });
 }
 public void addFoodCategory(loaiHangView view) throws Exception {
     String foodCategoryName = view.getTxtName().getText();
     if (foodCategoryName.isEmpty()) {
         throw new Exception("Vui lòng điền đủ thông tin");
     }
     if (LoaiHangRepo.findByName(foodCategoryName) != null) {
         throw new Exception("Tên loại đã tồn tại");
     }
     loaiHang f = new loaiHang();
     f.setTenLoaiHang(foodCategoryName);
     LoaiHangRepo.save(f);
 }
 public void editFoodCategory(loaiHangView view, loaiHang fc) throws Exception {
     String foodCategoryName = view.getTxtName().getText();
     if (foodCategoryName.isEmpty()) {
         throw new Exception("Điền tên loại món");
     }
     loaiHang temp = LoaiHangRepo.findByName(foodCategoryName);
     if (temp != null && temp.getTenLoaiHang() != fc.getTenLoaiHang()) {
         throw new Exception("Tên loại món đã được sử dụng");
     }
     fc.setTenLoaiHang(foodCategoryName);
     LoaiHangRepo.update(fc);
 }
}
