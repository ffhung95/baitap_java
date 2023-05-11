package window;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import LoginCf.Login;
//import Windows.Menu;
//import Windows.SideBar;
//import Windows.themmon_panel;

public class SideBar extends javax.swing.JFrame {
    private CardLayout card;
    /**
     * Creates new form SideBar
     */
    public SideBar() {
        initComponents();
        card = new CardLayout();
        Menu menu = new Menu();
        pnlLayout.setLayout(new BorderLayout());
        pnlLayout.add(jpnTaskbar,BorderLayout.WEST);
        pnlLayout.add(right_pnl,BorderLayout.CENTER);
        
        themmon_panel themmon = new themmon_panel();
        right_pnl.setLayout(card);
        right_pnl.add(menu.jpn_Menu, "Trang 1");
        right_pnl.add(themmon.qlimenu_jpn, "Trang 4");
        card.show(right_pnl,"Trang 1");
        setSize(1300, 790);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLayout = new javax.swing.JPanel();
        jpnTaskbar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Menu_btn = new javax.swing.JButton();
        qlimenu_btn = new javax.swing.JButton();
        nhapHang_btn = new javax.swing.JButton();
        thongKe_btn = new javax.swing.JButton();
        dangXuat_btn = new javax.swing.JButton();
        right_pnl = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        jLabel1.setFont(new java.awt.Font("Bradley Hand ITC", 1, 36)); // NOI18N
        jLabel1.setText("Cafe Sunshine");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Menu_btn.setBackground(new java.awt.Color(51, 204, 255));
        Menu_btn.setText("Thực đơn");
        Menu_btn.setMaximumSize(new java.awt.Dimension(60, 20));
        Menu_btn.setMinimumSize(new java.awt.Dimension(60, 20));
        Menu_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_btnActionPerformed(evt);
            }
        });

        qlimenu_btn.setBackground(new java.awt.Color(51, 255, 255));
        qlimenu_btn.setText("Quản lí Thực đơn");
        qlimenu_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qlimenu_btnActionPerformed(evt);
            }
        });

        nhapHang_btn.setBackground(new java.awt.Color(51, 255, 255));
        nhapHang_btn.setText("Nhập hàng");
        nhapHang_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapHang_btnActionPerformed(evt);
            }
        });

        thongKe_btn.setBackground(new java.awt.Color(51, 255, 255));
        thongKe_btn.setText("Thống kê hóa đơn");
        thongKe_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongKe_btnActionPerformed(evt);
            }
        });

        dangXuat_btn.setBackground(new java.awt.Color(51, 255, 255));
        dangXuat_btn.setText("Đăng xuất");
        dangXuat_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangXuat_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnTaskbarLayout = new javax.swing.GroupLayout(jpnTaskbar);
        jpnTaskbar.setLayout(jpnTaskbarLayout);
        jpnTaskbarLayout.setHorizontalGroup(
            jpnTaskbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Menu_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(thongKe_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
            .addComponent(qlimenu_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nhapHang_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTaskbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dangXuat_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnTaskbarLayout.setVerticalGroup(
            jpnTaskbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTaskbarLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(Menu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nhapHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thongKe_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qlimenu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1174, Short.MAX_VALUE)
                .addComponent(dangXuat_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout right_pnlLayout = new javax.swing.GroupLayout(right_pnl);
        right_pnl.setLayout(right_pnlLayout);
        right_pnlLayout.setHorizontalGroup(
            right_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        right_pnlLayout.setVerticalGroup(
            right_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlLayoutLayout = new javax.swing.GroupLayout(pnlLayout);
        pnlLayout.setLayout(pnlLayoutLayout);
        pnlLayoutLayout.setHorizontalGroup(
            pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1880, Short.MAX_VALUE)
            .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlLayoutLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpnTaskbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(459, Short.MAX_VALUE)))
            .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlLayoutLayout.createSequentialGroup()
                    .addGap(319, 319, 319)
                    .addComponent(right_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(110, Short.MAX_VALUE)))
        );
        pnlLayoutLayout.setVerticalGroup(
            pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1592, Short.MAX_VALUE)
            .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlLayoutLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpnTaskbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlLayoutLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(right_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void qlimenu_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qlimenu_btnActionPerformed
        card.show(right_pnl, "Trang 4");
        qlimenu_btn.setBackground(new Color(51,204,255));
        Menu_btn.setBackground(new Color(51,255,255));
        dangXuat_btn.setBackground(new Color(51,255,255));
        nhapHang_btn.setBackground(new Color(51,255,255));
        thongKe_btn.setBackground(new Color(51,255,255));
    }//GEN-LAST:event_qlimenu_btnActionPerformed

    private void Menu_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_btnActionPerformed
        card.show(right_pnl, "Trang 1");
        Menu_btn.setBackground(new Color(51,204,255));
        dangXuat_btn.setBackground(new Color(51,255,255));
        nhapHang_btn.setBackground(new Color(51,255,255));
        thongKe_btn.setBackground(new Color(51,255,255));
        qlimenu_btn.setBackground(new Color(51,255,255));
    }//GEN-LAST:event_Menu_btnActionPerformed

    private void nhapHang_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapHang_btnActionPerformed
        card.show(right_pnl, "Trang 2");
        nhapHang_btn.setBackground(new Color(51,204,255));
        Menu_btn.setBackground(new Color(51,255,255));
        dangXuat_btn.setBackground(new Color(51,255,255));
        thongKe_btn.setBackground(new Color(51,255,255));
        qlimenu_btn.setBackground(new Color(51,255,255));
    }//GEN-LAST:event_nhapHang_btnActionPerformed

    private void thongKe_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongKe_btnActionPerformed
        card.show(right_pnl, "Trang 3");
        thongKe_btn.setBackground(new Color(51,204,255));
        Menu_btn.setBackground(new Color(51,255,255));
        dangXuat_btn.setBackground(new Color(51,255,255));
        nhapHang_btn.setBackground(new Color(51,255,255));
        qlimenu_btn.setBackground(new Color(51,255,255));
    }//GEN-LAST:event_thongKe_btnActionPerformed

    private void dangXuat_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangXuat_btnActionPerformed
        int click = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (click == JOptionPane.YES_OPTION) {
//                    Login login = new Login();
//                    login.setVisible(true);
                    dispose();
                }
    }//GEN-LAST:event_dangXuat_btnActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SideBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SideBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SideBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SideBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SideBar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Menu_btn;
    private javax.swing.JButton dangXuat_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpnTaskbar;
    private javax.swing.JButton nhapHang_btn;
    private javax.swing.JPanel pnlLayout;
    private javax.swing.JButton qlimenu_btn;
    private javax.swing.JPanel right_pnl;
    private javax.swing.JButton thongKe_btn;
    // End of variables declaration//GEN-END:variables
}