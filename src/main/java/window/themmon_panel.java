package window;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

//import Dao.MenuDao;
//import Model.MenuModel;
//import Windows.themmon_panel;
//import Windows.themmon_panel.ImageRender;

public class themmon_panel extends javax.swing.JFrame {
    JLabel td;
    DefaultTableModel tblModel;
    private String id = "";
    private String tenmon = "";
    private String loai = "";
    private Float dgia;
    private byte[] anh;
    private File file;
    private  byte [] byteimage;
    
    public themmon_panel() {
        initComponents();
        initTabletd();
//        loadDataToTabletd();
    }

    private void initTabletd() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã món", "Tên món","loại", "Giá", "Hình ảnh"}); //Thiết lập danh sách tên cột cho bảng
        BangMenu.setModel(tblModel);//Gán tbtModel vào BangMenu
        BangMenu.getTableHeader().setReorderingAllowed(false);
        BangMenu.getColumnModel().getColumn(4).setCellRenderer(new ImageRender());
        BangMenu.setRowHeight(50);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        qlimenu_jpn = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        themMon = new javax.swing.JButton();
        xoaMon = new javax.swing.JButton();
        capnhatMon = new javax.swing.JButton();
        lammoiMon = new javax.swing.JButton();
        Nhapten = new javax.swing.JTextField();
        Nhapgia = new javax.swing.JTextField();
        Chonloai = new javax.swing.JComboBox<>();
        Nhapma = new javax.swing.JLabel();
        Nhapanh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Timkiem_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BangMenu = new javax.swing.JTable();
        NhapTimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBackground(new java.awt.Color(102, 102, 255));

        jLabel6.setBackground(new java.awt.Color(102, 102, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quản lí Menu");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );

        jLabel7.setText("Mã ID");

        jLabel8.setText("Tên món");

        jLabel11.setText("Loại");

        jLabel9.setText("Giá");

        jLabel10.setText("Hình ảnh");

        themMon.setText("Thêm");
        themMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                themMonActionPerformed(evt);
            }
        });

        xoaMon.setText("Xóa");
        xoaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                xoaMonActionPerformed(evt);
            }
        });

        capnhatMon.setText("Cập nhật");
        capnhatMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                capnhatMonActionPerformed(evt);
            }
        });

        lammoiMon.setText("Làm mới");
        lammoiMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                lammoiMonActionPerformed(evt);
            }
        });

        Nhapten.setBackground(new java.awt.Color(153, 153, 153));

        Nhapgia.setBackground(new java.awt.Color(153, 153, 153));

        Chonloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Cà phê", "Trà sữa", "Sinh tố", "Nước ép", " " }));
        Chonloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                ChonloaiActionPerformed(evt);
            }
        });

        Nhapma.setBackground(new java.awt.Color(204, 204, 204));
        Nhapma.setForeground(new java.awt.Color(0, 153, 153));

        Nhapanh.setBackground(new java.awt.Color(0, 255, 153));
        Nhapanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nhapanh.setText("Chọn ảnh");
        Nhapanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                NhapanhMouseClicked(evt);
            }
        });

        jLabel1.setText("Tìm kiếm mã món");

        Timkiem_btn.setText("Tìm kiếm");
        Timkiem_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                Timkiem_btnActionPerformed(evt);
            }
        });

        BangMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        BangMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                BangMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BangMenu);

        javax.swing.GroupLayout qlimenu_jpnLayout = new javax.swing.GroupLayout(qlimenu_jpn);
        qlimenu_jpn.setLayout(qlimenu_jpnLayout);
        qlimenu_jpnLayout.setHorizontalGroup(
            qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                            .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(xoaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(themMon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(118, 118, 118)
                            .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(capnhatMon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lammoiMon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(55, 55, 55))
                        .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                            .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Nhapma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Nhapten)
                                    .addComponent(Chonloai, 0, 153, Short.MAX_VALUE)
                                    .addComponent(Nhapgia))
                                .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Nhapanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(25, 25, 25))))
                .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NhapTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Timkiem_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        qlimenu_jpnLayout.setVerticalGroup(
            qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NhapTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Timkiem_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                        .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Nhapma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nhapten, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Chonloai, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nhapgia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 62, Short.MAX_VALUE))
                            .addComponent(Nhapanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(themMon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capnhatMon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(qlimenu_jpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lammoiMon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xoaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(qlimenu_jpnLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(qlimenu_jpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(qlimenu_jpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//    private void loadDataToTabletd() {    
//        try {
//            MenuDao menu= new MenuDao();
//            List<MenuModel> list = menu.findAll();
//            tblModel.setRowCount(0); //Xóa dữ liệu hiễn thị trên bảng và cho phép hiển thị lại dữ liệu
//            for (MenuModel tdn : list) {
//                tblModel.addRow(new Object[]{
//                    tdn.getMaMon(), tdn.getTenMon(),tdn.getLoai(), tdn.getDonGia(),tdn.getAnhMon()
//                });
//            }
//            tblModel.fireTableDataChanged();//Cập nhật hiển thị dữ liệu trong bảng
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    private class ImageRender extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus, int row, int colum){
            byte [] bytes = (byte[])value;
            ImageIcon imageIcon = new ImageIcon(bytes);
            Image img = imageIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(img));
            return this;
        }
    }
//    private void Reset(){
//        Nhapma.setText("");
//        Nhapten.setText("");
//        Chonloai.setSelectedItem("Tất cả");
//        Nhapgia.setText("");
//        Nhapanh.setText("Chọn ảnh");
//        Nhapanh.setIcon(null);
//        NhapTimKiem.setText("");
//        loadDataToTabletd();
//        
//    }
//    private void themMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themMonActionPerformed
//        try {
//            MenuDao dao = new MenuDao();
//            MenuModel menuModel = new MenuModel();
//            StringBuilder sb = new StringBuilder(); 
//            String gia = Nhapgia.getText();
//            loai = (String) Chonloai.getSelectedItem();
//            if (Nhapten.getText().equals("")) {
//            sb.append("Bạn chưa nhập tên món!!!");
//            } else if (loai.equals("Tất cả")) {
//                sb.append("Vui lòng chọn loại món!!!");
//            } else if (Nhapgia.getText().equals("")) {
//                sb.append("Bạn chưa nhập giá món!!!");
//            } 
//            else if (Nhapanh.getIcon() == null ) {
//                
//                sb.append("Bạn chưa nhập ảnh món!!!");
//            } else {
//                Pattern pattern = Pattern.compile("[0-9_-]$");
//                Matcher matchegia = pattern.matcher(gia);
//                if (matchegia.find()) {
//                    if (dao.findByMaMon(Nhapma.getText()) != null) {
//                        JOptionPane.showMessageDialog(null, "Món ăn đã tồn tại");
//                    } else {
//                        menuModel.setTenMon(Nhapten.getText());
//                        menuModel.setLoai(loai);
//                        menuModel.setDonGia(Float.valueOf(gia));
//                        menuModel.setAnhMon(Files.readAllBytes(file.toPath()));
//                        if (dao.insert(menuModel)) {
//                            JOptionPane.showMessageDialog(null, "Thêm món thành công");
//                            
//                            Reset();
//                        }
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số");
//                }
//            }
//            if (sb.length() > 0) {
//                JOptionPane.showMessageDialog(null, sb);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    private void ChonloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChonloaiActionPerformed
//        // TODO add your handling code here:
//    }//GEN-LAST:event_ChonloaiActionPerformed
//
//    private void capnhatMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatMonActionPerformed
//        try {
//            MenuDao dao = new MenuDao();
//            MenuModel menuModel = new MenuModel();
//            StringBuilder sb = new StringBuilder(); 
//            String gia = Nhapgia.getText();
//            loai = (String) Chonloai.getSelectedItem();         
//            if (Nhapten.getText().equals("")) {
//            sb.append("Bạn chưa nhập tên món!!!");
//            } else if (loai.equals("Tất cả")) {
//                sb.append("Vui lòng chọn loại món!!!");
//            } else if (Nhapgia.getText().equals("")) {
//                sb.append("Bạn chưa nhập giá món!!!");
//            } 
//            else if (Nhapanh.getIcon() == null) {
//                sb.append("Bạn chưa nhập ảnh món!!!");
//            } else {
//                menuModel.setMaMon(Integer.parseInt(Nhapma.getText()));
//                menuModel.setTenMon(Nhapten.getText());
//                menuModel.setLoai(loai);
//                menuModel.setDonGia(Float.valueOf(gia));
//                if(file == null){
//                   menuModel.setAnhMon(byteimage);
//                } else{
//                     menuModel.setAnhMon(Files.readAllBytes(file.toPath()));
//                }
//
//                Pattern pattern = Pattern.compile("[0-9_-]$");
//                Matcher matchegia = pattern.matcher(gia);
//                if (matchegia.find()) {
//                    if(id.equals(Nhapma.getText()) && tenmon.equals(Nhapten.getText()) && loai.equals(loai)&& dgia.equals(gia)&& anh.equals(Nhapanh.getText())){
//                        JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
//                        
//                        Reset();
//                    } else {
//                        if(dao.update(menuModel)){
//                            JOptionPane.showMessageDialog(null, "Cập nhật món thành công");
//                            
//                            Reset();
//                            if(id.equals(Nhapma.getText()) && tenmon.equals(Nhapten.getText()) && loai.equals(loai)&& dgia.equals(gia)&& anh.equals(Nhapanh.getText())){
//                                JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
//                               
//                                Reset();
//                            }
//                        } else if(dao.insert(menuModel)){
//                            JOptionPane.showMessageDialog(null, "Thêm món thành công");
//                            
//                            Reset();
//                        }
//                    }
//                    
//                } else {
//                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số");
//                }
//            }
//            if (sb.length() > 0) {
//                JOptionPane.showMessageDialog(null, sb);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }//GEN-LAST:event_capnhatMonActionPerformed
//
//    private void xoaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaMonActionPerformed
//        try {
//            MenuDao menu = new MenuDao();
//            if (menu.delete(id)) {
//                JOptionPane.showMessageDialog(null, "Xóa thành công");
//                
//                Reset();
//            } else {
//                JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng để xóa");
//            }
//        } catch (Exception e) {
//        }
//    }//GEN-LAST:event_xoaMonActionPerformed
//
//    private void lammoiMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lammoiMonActionPerformed
//        Reset();
//    }//GEN-LAST:event_lammoiMonActionPerformed
//
//    private void Timkiem_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Timkiem_btnActionPerformed
//        try {
//            MenuModel menu = new MenuModel();
//            MenuDao dao = new MenuDao();
//            menu.setTenMon(NhapTimKiem.getText());
//            if (dao.findtableTenmon(NhapTimKiem.getText()) != null) {
//                List<MenuModel> list = dao.findtableTenmon(NhapTimKiem.getText());
//                tblModel.setRowCount(0); //Xóa dữ liệu hiễn thị trên bảng và cho phép hiển thị lại dữ liệu
//                for (MenuModel tdn : list) {
//                    tblModel.addRow(new Object[]{
//                        tdn.getMaMon(), tdn.getTenMon(),tdn.getLoai(), tdn.getDonGia(),tdn.getAnhMon()
//                    });
//                }
//                tblModel.fireTableDataChanged();//Cập nhật hiển thị dữ liệu trong bảng
//            } else {
//                JOptionPane.showMessageDialog(null, "Không tìm thấy!!!");
//            }
//        } catch (Exception e) {
//        }
//    }//GEN-LAST:event_Timkiem_btnActionPerformed
//
//    private void BangMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangMenuMouseClicked
//        int row = BangMenu.getSelectedRow();
//        try {
//            if (row >= 0) {
//                id = BangMenu.getValueAt(row, 0).toString(); //Tại cột đầu tiên
//                tenmon = BangMenu.getValueAt(row, 1).toString(); //Tại cột đầu tiên
//                loai = BangMenu.getValueAt(row, 2).toString(); //Tại cột đầu tiên
//                dgia = (Float) BangMenu.getValueAt(row, 3); //Tại cột đầu tiên
//                //anh = BangMenu.getValueAt(row, 4).toString();
//                MenuDao dao = new MenuDao();
//                MenuModel menu = dao.findByMaMon(id);
//                if (menu != null) {
//                    Nhapma.setText(Integer.toString(menu.getMaMon()));
//                    Nhapten.setText(menu.getTenMon());
//                    Chonloai.setSelectedItem(menu.getLoai());
//                    Nhapgia.setText(String.valueOf(menu.getDonGia()));
//                    Nhapanh.getText();
//                    byteimage = (byte[])menu.getAnhMon();
//                    ImageIcon imageIcon = new ImageIcon(byteimage);
//                   
//                    int width = Nhapanh.getWidth();
//                    int height = Nhapanh.getHeight();
//                    Image img = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
//                    Nhapanh.setIcon(new ImageIcon(img));
//                }
//            }
//        } catch (Exception e) {
//        }
//    }//GEN-LAST:event_BangMenuMouseClicked
//
//    private void NhapanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhapanhMouseClicked
//        try {
//        JFileChooser fileChooser = new JFileChooser();
//        // Chỉ cho phép chọn các file ảnh
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
//        fileChooser.setFileFilter(filter);
//        fileChooser.showOpenDialog(null);
//        file = fileChooser.getSelectedFile();
//        if (file != null) {
//            Image img = ImageIO.read(file);
//            Nhapanh.setText("");
//            int width = Nhapanh.getWidth();
//            int height = Nhapanh.getHeight();
//            Nhapanh.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
//        } 
////        else {
////            JOptionPane.showMessageDialog(null, "Bạn chưa chọn tập tin hình ảnh!!!");
////        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    }//GEN-LAST:event_NhapanhMouseClicked
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(themmon_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(themmon_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(themmon_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(themmon_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new themmon_panel().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangMenu;
    private javax.swing.JComboBox<String> Chonloai;
    private javax.swing.JTextField NhapTimKiem;
    private javax.swing.JLabel Nhapanh;
    private javax.swing.JTextField Nhapgia;
    private javax.swing.JLabel Nhapma;
    private javax.swing.JTextField Nhapten;
    private javax.swing.JButton Timkiem_btn;
    private javax.swing.JButton capnhatMon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lammoiMon;
    public javax.swing.JPanel qlimenu_jpn;
    private javax.swing.JButton themMon;
    private javax.swing.JButton xoaMon;
    // End of variables declaration//GEN-END:variables
}