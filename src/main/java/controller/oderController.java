//package controller;
//import java.text.DecimalFormat;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import controller.treatment.hangHoatreatmentController;
//import model.datHang;
//import model.loaiHang;
//import model.nhanVienModel;
//import model.oderItem;
//import model.table;
//import repository.NhanVienReposity;
//import repository.datHangRepository;
//import repository.oderItemRepository;
//import repository.tableRepository;
//import utils.OrderType;
//import utils.TableStatus;
//import view.trangChu.hangHoaView;
//import view.trangChu.suaDonHangView;
//import view.trangChu.themDonHangView;
//import view.trangChu.toppingView;
//
//public class oderController {
//	datHangRepository orderDao = new datHangRepository();
//    NhanVienReposity employeeDao = new NhanVienReposity();
//    tableRepository tableDao = new tableRepository();
//    oderItemRepository orderItemDao = new oderItemRepository();
//    hangHoatreatmentController foodItemController = new hangHoatreatmentController();
//    orderItemController orderItemController = new orderItemController();
//    toppingController toppingPopupController = new toppingController();
////    PrintOrderController printOrderController = new PrintOrderController();
//    DecimalFormat formatter = new DecimalFormat("###,###,###");
//    JFrame previousView;
//
//    public void updateAmount(suaDonHangView view, datHang order) {
//        order.setTotal(orderItemController.getTotalAmount());
//        view.getLbDiscount().setText(order.getDiscount() + "");
//        view.getLbTotalAmount().setText(formatter.format(order.getTotal()));
//    }
//
//    public boolean addOrder(themDonHangView view) throws Exception {
////        datHang dathang = new datHang();
//        table table = (table) view.getTbComboBoxModel().getSelectedItem();
//        int discount = (int) view.getSpnDiscount().getValue();
//        if (table == null) {
//            throw new Exception("Hết bàn");
//        }
//        if (discount < 0 || discount > 100) {
//            throw new Exception("Discount phải nằm trong khoảng 0-100");
//        }
//        datHang order = new datHang();
//        order.setIdBan(table.getMaBan());
//        order.setDiscount(discount);
//        
//        orderDao.save(order);
//        tableDao.update(table);
//        return true;
//    }
//
//    public boolean editOrder(suaDonHangView view, datHang order) throws Exception {
//        if (order.getBan() == null) {
//            throw new Exception("Hết bàn");
//        }
//        if (order.getDiscount() < 0 || order.getDiscount() > 100) {
//            throw new Exception("Discount phải nằm trong khoảng 0-100");
//        }
//        for(oderItem orderItem : orderItemController.getOrderItems()) {
//            if (orderItem.getSoluong() <= 0) {
//                orderItemDao.delete(orderItem);
//            } else {
//                orderItemDao.save(orderItem);
//            }
//        }
//       
//        order.setTotal(orderItemController.getTotalAmount());
//        orderDao.update(order);
//        tableDao.update(order.getBan());
//
//        return true;
//    }
//   
//    public void add(themDonHangView view) {
//        if (previousView != null && previousView.isDisplayable()) {
//            previousView.requestFocus();
//            return;
//        }
//        previousView = view;
//        view.setVisible(true);
//        view.getBtnCancel().addActionListener(evt -> view.dispose());
//        try {
//            for (table ban : tableDao.getAll()) {
//                if (ban.getTrangthai() == TableStatus.FREE) {
//                    view.getTbComboBoxModel().addElement(ban);
//                }
//            }
//        } catch (Exception e) {
//            view.dispose();
//            return;
//        }   
//        view.getBtnOK().addActionListener(evt -> {
//            try {
//                addOrder(view);
//                view.dispose();
//                view.showMessage("Tạo hóa đơn thành công!");
//            } catch (Exception ex) {
//            }
//        });
//
//    }
//
//    public void edit(suaDonHangView view, datHang order) {
//        if (previousView != null && previousView.isDisplayable()) {
//            previousView.requestFocus();
//            return;
//        }
//        previousView = view;
//        view.setVisible(true);
//        view.getBtnCancel().addActionListener(evt -> view.dispose());
//        orderItemController.setPanelOrderItem(view.getPnlOrderItem());
//        orderItemController.setIdOrder(order.getId());
//        orderItemController.setOnQuantityChange(() -> {
//            updateAmount(view, order);
//        });
//        foodItemController.setPanelFoodCategory(view.getPnlFoodCategory());
//        foodItemController.setPanelFoodItem(view.getPnlFoodItem());
//        view.getLbIdOrder().setText(order.getId() + "");
//        try {
//            for (table table : tableDao.getAll()) { // Hiển thị danh sách bàn
//                if (table.getTrangthai() == TableStatus.FREE || table.getMaBan() == order.getIdBan()) {
//                    view.getTbComboBoxModel().addElement(table);
//                }
//            }
//            for (OrderType ot : OrderType.values()) { // Hiển thị loại hóa đơn
//                view.getCboType().addItem(ot.getName());
//            }
//            orderItemController.setOrderItems(orderItemDao.getByIdOrder(order.getId()));
//            foodItemController.renderCategory(foodItem -> {//Hiển thị danh sách món ăn
//                toppingPopupController.add(new toppingView(), foodItem, orderItem -> {
//                    orderItemController.addOrderItem(orderItem);// Thêm vào danh sách order
//                    updateAmount(view, order);
//                });
//            });
//            view.getTbComboBoxModel().setSelectedItem(order.getBan());
//            view.getSpnDiscount().setValue(order.getDiscount());
//            view.getLbDiscount().setText(order.getDiscount() + "");
//
//        } catch (Exception e) {
//            view.dispose();
// 
//            return;
//        }
//        updateAmount(view, order);
//        view.getBtnOK().setText("Cập nhật");
//        view.getSpnDiscount().addChangeListener(evt -> { // Thay giá trị
//            order.setDiscount((int) view.getSpnDiscount().getValue());
//            updateAmount(view, order);
//        });
//        view.getCboTable().addActionListener(evt -> { // Thay bàn
//            try {
//                table nTable = (table) view.getTbComboBoxModel().getSelectedItem(),
//                        cTable = order.getBan();
//                if (nTable == null || (cTable != null && nTable.getMaBan() == cTable.getMaBan())) {
//                    return;
//                }
//                cTable.setTrangthai(TableStatus.FREE);
//                nTable.setTrangthai(TableStatus.SERVING);
//                order.setBan(nTable);
//                tableDao.update(cTable);
//                tableDao.update(nTable);
//            } catch (Exception ex) {
//              
//            }
//        });
//        view.getBtnOK().addActionListener(evt -> {
//            try {
//                editOrder(view, order);
//                view.showMessage("Sửa hóa đơn thành công!");
//                updateAmount(view, order);
//            } catch (Exception ex) {
//               
//            }
//        });
//
//        view.getBtnPaid().addActionListener(evt -> {
//            try {
//                String rawInput = JOptionPane.showInputDialog(null, "Nhập số tiền thanh toán!", order.getTotal());
//                if (rawInput == null) {
//                    return;
//                }
//                int paidAmount = Integer.parseInt(rawInput);
//               
//                order.setTotal(paidAmount);
//                updateAmount(view, order);
//            } catch (Exception e) {
//              
//            }
//        });
//
//    }
//}
