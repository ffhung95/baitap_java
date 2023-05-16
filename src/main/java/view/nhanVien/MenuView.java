/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.nhanVien;

import model.hangHoa;
import model.table;
import repository.hangHoaRepository;
import repository.tableRepository;
import utils.TableStatus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MenuView extends javax.swing.JFrame {

    private JPanel productPanel;
    private tableRepository tableRe;
    
    private JPanel deskCfPanel;
    private JPanel boxDesk;
    private JPanel boxDrink;
    private JSpinner spQuantity;
    private List<JSpinner> mySpinners = new ArrayList<>();
    Map<Integer, Float> menuMap = new HashMap<>(); 
    private List<hangHoa> drinks;
    private List<table> desks;
    private float total = (float) 0.0;
    private int x = 0;
    private float tax = (float) 0.0;

    public MenuView() {
    	tableRe = new tableRepository();
        initComponents();
        thucDon();
        banCF();
        setSize(1219, 800);
    }

    public void thucDon() {
        try {
            pnlProduct.setLayout(new BorderLayout());
            productPanel = new JPanel(new GridLayout(0, 4, 10, 10));
            hangHoaRepository dao = new hangHoaRepository();
            drinks = dao.getAll();
            for (hangHoa drink : drinks) {
                boxDrink = new JPanel();
                boxDrink.setLayout(new BoxLayout(boxDrink, BoxLayout.Y_AXIS));
                JLabel nameLbl = new JLabel("Tên: " + drink.getTenHangHoa());
                JLabel priceLbl = new JLabel("Giá: " + drink.getGiaHangHoa() + " VND");
                JLabel imageLbl = new JLabel();
                byte[] bytes = (byte[]) drink.getAnhHangHoa();
                ImageIcon icon = new ImageIcon(bytes);
                Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imageLbl.setIcon(new ImageIcon(img));
               
                JPanel quantityPnl = new JPanel();
                quantityPnl.setLayout(new BoxLayout(quantityPnl, BoxLayout.X_AXIS));
                JLabel quantityLbl = new JLabel("Số lượng: ");
                SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 100, 1);
                spQuantity = new JSpinner(model);
                spQuantity.setMaximumSize(new Dimension(60, spQuantity.getPreferredSize().height));
                mySpinners.add(spQuantity);
                //defaultValues.add(i);
                quantityPnl.add(quantityLbl);
                quantityPnl.add(spQuantity);
                quantityPnl.setAlignmentX(LEFT_ALIGNMENT);
                //Gá»i vÃ o panel boxDrink
                boxDrink.add(imageLbl);
                boxDrink.add(nameLbl);
                boxDrink.add(priceLbl);
                boxDrink.add(quantityPnl);
                productPanel.add(boxDrink);
               
                spQuantity.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        JSpinner source = (JSpinner) e.getSource();
                        int value = (Integer) source.getModel().getValue();
                        handleQuantity(menuMap, drink.getMaHangHoa(), drink.getTenHangHoa(), value, drink.getGiaHangHoa());
                    }
                });
            }
            JScrollPane scrollPane = new JScrollPane(productPanel);
            pnlProduct.add(scrollPane, BorderLayout.CENTER);
            setTime();
            Sunshine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void banCF() {
        try {
            pnlBanCF.setLayout(new BorderLayout());
            deskCfPanel = new JPanel(new GridLayout(0, 1, 10, 10));
            tableRepository dao = new tableRepository();
            desks = dao.getAll();
            for (table desk : desks) {
                boxDesk = new JPanel();
                boxDesk.setLayout(new BoxLayout(boxDesk, BoxLayout.Y_AXIS));
                JLabel nameLbl = new JLabel("Bàn"+ desk.getMaBan()+" "+desk.getTrangthai());
                JButton oder = new JButton("Gọi món");
                oder.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                    thucDon();
                    desk.setTrangthai(TableStatus.SERVING);
                    nameLbl.setText("Bàn "+desk.getMaBan()+" "+desk.getTrangthai());
                    try {
						tableRe.update(desk);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            });
                oder.setPreferredSize(new Dimension(100, 50));
                JButton pay = new JButton("Thanh toán");
                pay.addActionListener(new ActionListener(){
                    @Override
                public void actionPerformed(ActionEvent e) {
                    	
                    	 desk.setTrangthai(TableStatus.FREE);
                    	 nameLbl.setText("Bàn "+desk.getMaBan()+" "+desk.getTrangthai());
                    	 try {
     						tableRe.update(desk);
     					} catch (SQLException e1) {
     						// TODO Auto-generated catch block
     						e1.printStackTrace();
     					}
                    
                }
                });
                pay.setPreferredSize(new Dimension(100, 50));
                boxDesk.add(nameLbl);
                boxDesk.add(oder);
                boxDesk.add(pay);
                deskCfPanel.add(boxDesk);
            }
            JScrollPane scrollPane = new JScrollPane(deskCfPanel);
            pnlBanCF.add(scrollPane, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Reset() {
        total = (float) 0.0;
        x = 0;
        tax = 0;
        btnTotal.setEnabled(true);
        for (int i = 0; i < mySpinners.size(); i++) {
            JSpinner spinner = mySpinners.get(i);
            SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
            model.setValue(0);
        }
        jtfTax.setText("0.0");
        jTextFieldSubTotal.setText("0.0");
        jTextFieldTotal.setText("0.0");
        textBill.setText("");
        Sunshine();

    }

    public void dudate() {
        jtfTax.setText(String.valueOf(tax));
        jTextFieldSubTotal.setText(String.valueOf(total));
        jTextFieldTotal.setText(String.valueOf(total + tax));

    }

    public boolean qtyIsZero(int qty) {
        if (qty == 0) {
            JOptionPane.showMessageDialog(jpn_Menu, "Vui lòng chọn số lượng");
            return false;
        }
        return true;
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpn_Menu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTxTime = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtDate = new javax.swing.JLabel();
        jtfTax = new javax.swing.JTextField();
        jTextFieldSubTotal = new javax.swing.JTextField();
        jTextFieldTotal = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textBill = new javax.swing.JTextArea();
        jPanel21 = new javax.swing.JPanel();
        btnTotal = new javax.swing.JButton();
        btn_Inhoadon = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        pnlProduct = new javax.swing.JPanel();
        pnlBanCF = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpn_Menu.setPreferredSize(new java.awt.Dimension(1360, 790));

        jPanel2.setBackground(new java.awt.Color(235, 235, 235));
        jPanel2.setPreferredSize(new java.awt.Dimension(1360, 45));

        jTxTime.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thá»±c Ä‘Æ¡n");

        jTxtDate.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxTime, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(376, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTxTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtfTax.setEditable(false);
        jtfTax.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jtfTax.setText("0.0");

        jTextFieldSubTotal.setEditable(false);
        jTextFieldSubTotal.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTextFieldSubTotal.setText("0.0");

        jTextFieldTotal.setEditable(false);
        jTextFieldTotal.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTextFieldTotal.setText("0.0");

        jLabel63.setText("FAX");

        jLabel64.setText("SUB TOTAL");

        jLabel65.setText("TOTAL");

        textBill.setColumns(20);
        textBill.setRows(5);
        jScrollPane1.setViewportView(textBill);

        btnTotal.setBackground(new java.awt.Color(0, 153, 0));
        btnTotal.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnTotal.setText("Total");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        btn_Inhoadon.setBackground(new java.awt.Color(51, 255, 204));
        btn_Inhoadon.setText("In hÃ³a Ä‘Æ¡n");
        btn_Inhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InhoadonActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 51, 51));
        btnExit.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(0, 102, 255));
        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnTotal)
                .addGap(115, 115, 115)
                .addComponent(btn_Inhoadon)
                .addGap(99, 99, 99)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(54, 54, 54))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTotal)
                    .addComponent(btn_Inhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlProductLayout = new javax.swing.GroupLayout(pnlProduct);
        pnlProduct.setLayout(pnlProductLayout);
        pnlProductLayout.setHorizontalGroup(
            pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );
        pnlProductLayout.setVerticalGroup(
            pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBanCFLayout = new javax.swing.GroupLayout(pnlBanCF);
        pnlBanCF.setLayout(pnlBanCFLayout);
        pnlBanCFLayout.setHorizontalGroup(
            pnlBanCFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );
        pnlBanCFLayout.setVerticalGroup(
            pnlBanCFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpn_MenuLayout = new javax.swing.GroupLayout(jpn_Menu);
        jpn_Menu.setLayout(jpn_MenuLayout);
        jpn_MenuLayout.setHorizontalGroup(
            jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_MenuLayout.createSequentialGroup()
                .addGroup(jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_MenuLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpn_MenuLayout.createSequentialGroup()
                        .addComponent(pnlBanCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_MenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_MenuLayout.createSequentialGroup()
                                .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(134, 134, 134))
                            .addGroup(jpn_MenuLayout.createSequentialGroup()
                                .addGroup(jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfTax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(jpn_MenuLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1187, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpn_MenuLayout.setVerticalGroup(
            jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_MenuLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_MenuLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addGroup(jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpn_MenuLayout.createSequentialGroup()
                        .addGroup(jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlBanCF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 1187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void handleQuantity(Map menuMap, int id, String name, int quantity, float price) {
        int qty = (Integer) quantity;
        float prices = qty * price;
        if (menuMap.containsKey(id)) {
         
        	float oldPrices = (float) menuMap.get(id);
            if (prices == 0.0) {
                String oldName = name + "\t\t\t" + oldPrices + "\n";
                String text = textBill.getText();
                int index = text.indexOf(oldName);
                if (index >= 0) {
                    int end = index + oldName.length();
                    textBill.replaceRange("", index, end);
                }
                menuMap.remove(id);
            } else {
                menuMap.put(id, prices);
                // Cáº­p nháº­t sá»‘ lÆ°á»£ng mÃ³n trong bill
                String newText = textBill.getText().replaceAll(name + "\t\t\t" + oldPrices + "\n", name + "\t\t\t" + prices + "\n");
                textBill.setText(newText);
            }
        } else {
      
            textBill.append(name + "\t\t\t" + prices + "\n");
            menuMap.put(id, prices);
        }
    }


    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        Reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       dispose();
      TrangChuNV view = new TrangChuNV();
      view.setVisible(true);
    }
    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        for (Map.Entry<Integer, Float> entry : menuMap.entrySet()) {
            double prices = entry.getValue();
            total += prices;
        }
        if (total == 0.0) {
            JOptionPane.showMessageDialog(jpn_Menu, "Bạn chưa chọn món!");

        } else {
            textBill.setText(textBill.getText() + "\n**********************************************\n"
                    + "Tax: \t\t\t" + tax + "\n"
                    + "Sub Total \t\t\t" + total + "\n"
                    + "Total \t\t\t" + (total + tax) + "\n\n"
                    + "***************************Thank you*******************\n"
            );
            btnTotal.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalActionPerformed

    private void btn_InhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InhoadonActionPerformed
        System.out.println(menuMap);
        if (!menuMap.isEmpty()) {
            if (!btnTotal.isEnabled()) {
                try {
                    textBill.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(jpn_Menu, "Bạn chưa thanh toán");
            }
        } else {
            JOptionPane.showMessageDialog(jpn_Menu, "Bạn chưa mua sản phẩm nào");
        }
    }//GEN-LAST:event_btn_InhoadonActionPerformed
    public void Sunshine() {
    	 
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentDateTime.format(timeFormatter);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy EEEE");
        String formattedDate = currentDateTime.format(dateFormatter);
        textBill.append("Sunshine\n" + "Time: " + formattedTime + "\n"
                + "Date: " + formattedDate + "\n"
                + "**********************************************\n"
                + "Item Name: \t\t\t"
                + "Gia: \n");
       
    }

    public void getTax(int t) {
        if (t > 10.0) {
            tax = (float) 0.5;
        } else if (t > 20.0 && t <= 30.0) {
            tax = (float) 1.0;
        }
    }

    public void setTime() {
        new Thread(new Runnable() {
            @Override

            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        java.util.logging.Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                    String time = tf.format(date);
                    jTxTime.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    jTxtDate.setText(df.format(date));
                }
            }
        }).start();
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTotal;
    private javax.swing.JButton btn_Inhoadon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSubTotal;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JLabel jTxTime;
    private javax.swing.JLabel jTxtDate;
    public javax.swing.JPanel jpn_Menu;
    private javax.swing.JTextField jtfTax;
    private javax.swing.JPanel pnlBanCF;
    private javax.swing.JPanel pnlProduct;
    private javax.swing.JTextArea textBill;
    // End of variables declaration//GEN-END:variables
}
