package view.nhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.hangHoa;
import model.table;
import repository.hangHoaRepository;
import repository.tableRepository;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuView extends JFrame {
	 private JPanel productPanel;
	 private JPanel deskCfPanel;
	    private JPanel boxDrink;
	    private JPanel boxDesk;
	    private JSpinner spQuantity;
	    private List<JSpinner> mySpinners = new ArrayList<>();
	    Map<Integer, Float > menuMap = new HashMap<>(); //Khai báo một map để lưu các món trong bill
	    private int valuess=0;
	    private List<hangHoa> drinks;
	    private List<table> desks;
	    /**
	     * Creates new form Menu
	     */
	    private float total = (float) 0.0;
	    private int x=0;
	    private float tax = (float)0.0;
	    public MenuView() {
	        try {
	            initComponents();
	            pnlProduct.setLayout(new BorderLayout());
	            productPanel = new JPanel(new GridLayout(0,4,10,10));
	            hangHoaRepository dao = new hangHoaRepository();
	            drinks = dao.getAll();        
	            for (hangHoa drink : drinks) {
	            	if(drink.getSoLuong()>0) {
	            		  boxDrink = new JPanel();
	  	                boxDrink.setLayout(new BoxLayout(boxDrink, BoxLayout.Y_AXIS));
	  	                JLabel nameLbl = new JLabel("Tên: " + drink.getTenHangHoa());
	  	                JLabel priceLbl = new JLabel("Giá: " + drink.getGiaHangHoa() + " VNĐ");
	  	                //Hình ảnh
	  	                JLabel imageLbl = new JLabel();
	  	                byte [] bytes = (byte[])drink.getAnhHangHoa();
	  	                ImageIcon icon = new ImageIcon(bytes);
	  	                Image img = icon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
	  	                imageLbl.setIcon(new ImageIcon(img));
	  	                //Số lượng
	  	                JPanel quantityPnl = new JPanel();
	  	                quantityPnl.setLayout(new BoxLayout(quantityPnl, BoxLayout.X_AXIS));
	  	                JLabel quantityLbl = new JLabel("Số lượng: ");
	  	                int soluong = drink.getSoLuong();
	  	                SpinnerNumberModel model = new SpinnerNumberModel(0, 0, soluong, 1);
	  	                spQuantity = new JSpinner(model);
	  	                spQuantity.setMaximumSize(new Dimension(100, spQuantity.getPreferredSize().height));
	  	                mySpinners.add(spQuantity);
	  	                JLabel lblNewLabel = new JLabel("Chọn");
	  	        		lblNewLabel.addMouseListener(new MouseAdapter() {
	  	        			@Override
	  	        			public void mouseClicked(MouseEvent e) {
	  	        				 handleQuantity(menuMap, drink.getMaHangHoa(), drink.getTenHangHoa(), valuess, drink.getGiaHangHoa());
	  	        				 drink.setSoLuong(drink.getSoLuong()-valuess);
	  	     	                try {
	  								dao.capNhatSoLuong(drink);
	  							} catch (SQLException e1) {
	  								// TODO Auto-generated catch block
	  								e1.printStackTrace();
	  							}
	  	        			}
	  	        		});       		
	  	                quantityPnl.add(quantityLbl);
	  	                quantityPnl.add(spQuantity);
	  	                quantityPnl.setAlignmentX(LEFT_ALIGNMENT);
	  	                //Mua
	  	                JPanel selectPnl = new JPanel(); //Panel
	  	                selectPnl.setLayout(new BoxLayout(selectPnl, BoxLayout.X_AXIS));

	  	                boxDrink.add(imageLbl);
	  	                boxDrink.add(nameLbl);
	  	                boxDrink.add(priceLbl);
	  	                boxDrink.add(quantityPnl);
	  	                boxDrink.add(lblNewLabel);

	  	                productPanel.add(boxDrink);
	  	                spQuantity.addChangeListener(new ChangeListener() {
	  	                @Override
	  	                public void stateChanged(ChangeEvent e) {
	  	                    JSpinner source = (JSpinner) e.getSource();
	  	                     valuess = (Integer) source.getModel().getValue();
	  	                }
	  	                });
	            	}
	              
	               
	               
	            }
	            JScrollPane scrollPane = new JScrollPane(productPanel);
	            pnlProduct.add(scrollPane, BorderLayout.CENTER);// thieets kees layout 
	            
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
	                JLabel nameLbl = new JLabel("Bàn "+ desk.getName());
	                JButton oder = new JButton("Gọi món");
	                oder.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // Tạo JFrame mới để hiển thị menu
//	                    thucDon();
	                }
	            });
	                oder.setPreferredSize(new Dimension(100, 50));
	                JButton pay = new JButton("Thanh toán");
	                pay.addActionListener(new ActionListener(){
	                    @Override
	                public void actionPerformed(ActionEvent e) {
	                    // Tạo JFrame mới để hiển thị menu
	                    
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
	    public boolean qtyIsZero(int qty){
	        if(qty == 0) {
	            JOptionPane.showMessageDialog(null, "Please increase the item quantity");
	            return false;
	        }
	        return true;
	    }
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	    private void initComponents() {

	        jpn_Menu = new javax.swing.JPanel();
	        jPanel2 = new javax.swing.JPanel();
	        jLabel1 = new javax.swing.JLabel();
	        jTxTime = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        textBill = new javax.swing.JTextArea();
	        jPanel21 = new javax.swing.JPanel();
	        pnlProduct = new javax.swing.JPanel();
	        jTxtDate = new javax.swing.JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jpn_Menu.setPreferredSize(new java.awt.Dimension(1360, 790));

	        jPanel2.setBackground(new java.awt.Color(235, 235, 235));
	        jPanel2.setPreferredSize(new java.awt.Dimension(1360, 45));

	        jLabel1.setFont(new java.awt.Font("Bradley Hand ITC", 1, 36)); // NOI18N
	        jLabel1.setText("Menu");

	        jTxTime.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

	        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
	        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addGap(30, 30, 30)
	                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(77, 77, 77)
	                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(102, 102, 102)
	                .addComponent(jTxTime, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(256, Short.MAX_VALUE))
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
	                    .addComponent(jTxTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        textBill.setColumns(20);
	        textBill.setRows(5);
	        jScrollPane1.setViewportView(textBill);

	        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
	        jPanel21Layout.setHorizontalGroup(
	        	jPanel21Layout.createParallelGroup(Alignment.LEADING)
	        		.addGap(0, 795, Short.MAX_VALUE)
	        );
	        jPanel21Layout.setVerticalGroup(
	        	jPanel21Layout.createParallelGroup(Alignment.LEADING)
	        		.addGap(0, 72, Short.MAX_VALUE)
	        );
	        jPanel21.setLayout(jPanel21Layout);

	        javax.swing.GroupLayout pnlProductLayout = new javax.swing.GroupLayout(pnlProduct);
	        pnlProduct.setLayout(pnlProductLayout);
	        pnlProductLayout.setHorizontalGroup(
	            pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );
	        pnlProductLayout.setVerticalGroup(
	            pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );

	        javax.swing.GroupLayout jpn_MenuLayout = new javax.swing.GroupLayout(jpn_Menu);
	        jpn_MenuLayout.setHorizontalGroup(
	        	jpn_MenuLayout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(jpn_MenuLayout.createSequentialGroup()
	        			.addGroup(jpn_MenuLayout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(pnlProduct, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
	        				.addComponent(jPanel21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addGap(5)
	        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap())
	        		.addGroup(jpn_MenuLayout.createSequentialGroup()
	        			.addContainerGap()
	        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 1241, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        jpn_MenuLayout.setVerticalGroup(
	        	jpn_MenuLayout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(jpn_MenuLayout.createSequentialGroup()
	        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(jpn_MenuLayout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
	        				.addGroup(jpn_MenuLayout.createSequentialGroup()
	        					.addComponent(pnlProduct, GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(jPanel21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        					.addContainerGap())))
	        );
	        jpn_Menu.setLayout(jpn_MenuLayout);

	        jTxtDate.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jpn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGap(0, 0, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jTxtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jpn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)))
	        );

	        pack();
	    }// </editor-fold>//GEN-END:initComponents
	    private void handleQuantity(Map menuMap, int id, String name, int quantity, double price) {
	       int qty = (Integer) quantity;
	       double prices = qty * price;
	       if (menuMap.containsKey(id)) {
	            // Món đã tồn tại trong bill, cập nhật số lượng
	            float oldPrices = (float) menuMap.get(id);
	            if(prices == 0.0){
	                String oldName = name+"\t\t\t"+oldPrices+"\n";
	                String text = textBill.getText();
	                int index = text.indexOf(oldName);
	                if(index >=0){
	                    int end = index + oldName.length();
	                    textBill.replaceRange("", index, end);
	                }
	                menuMap.remove(id);   
	            }else{
	                menuMap.put(id, prices);
	                // Cập nhật số lượng món trong bill
	                String newText = textBill.getText().replaceAll(name+"\t\t\t"+oldPrices+"\n", name+"\t\t\t"+prices+"\n");
	                textBill.setText(newText);
	            }           
	        } else {
	            // Món chưa có trong bill, thêm mới
	            textBill.append(name+"\t\t\t"+prices+"\n");
	            menuMap.put(id, prices);
	        }
	}
	    public void Sunshine(){
	         LocalDateTime currentDateTime = LocalDateTime.now();
	    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	    String formattedTime = currentDateTime.format(timeFormatter);
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy EEEE");
	    String formattedDate = currentDateTime.format(dateFormatter);
	    
	    textBill.append("Sunshine\n" + "Time: " + formattedTime + "\n" +
	        "Date: " + formattedDate + "\n" +
	        "**********************************************\n" +
	        "Item Name: \t\t\t" +
	        "Gia: \n");
	    }     
	    public void getTax(int t){
	        if(t>10.0){
	            tax = (float) 0.5;
	        } else if (t>20.0 && t<= 30.0){
	            tax = (float) 1.0;
	        }
	    }
	    public void setTime(){
	        new Thread(new Runnable(){
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
	                    jTxTime.setText(time.split(" ")[0]+" "+time.split(" ")[1]);
	                    jTxtDate.setText(df.format(date));
	                }
	            }          
	        }).start();
	    }
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String args[]) {
	        
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new MenuView().setVisible(true);
	            }
	        });
	        
	    }
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JPanel jPanel2;
	    private javax.swing.JPanel jPanel21;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JLabel jTxTime;
	    private javax.swing.JLabel jTxtDate;
	    public javax.swing.JPanel jpn_Menu;
	    private javax.swing.JPanel pnlProduct;
	    private javax.swing.JPanel pnlBanCF;
	    private javax.swing.JTextArea textBill;
}
