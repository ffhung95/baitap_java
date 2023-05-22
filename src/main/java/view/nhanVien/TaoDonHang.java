package view.nhanVien;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.TableStatus;
import view.loginView;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.views.AbstractView;

import model.PhienLamViec;
import model.hangHoa;
import model.nhanVienModel;
import model.table;
import repository.NhanVienReposity;
import repository.PhienLamViecRepository;
import repository.hangHoaRepository;
import repository.tableRepository;
import utils.TableStatus;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class TaoDonHang extends JFrame {
	private JPanel pmenu;
	private JPanel contentPane;
	private JPanel panel;	
	private JPanel pban;

	private JSpinner spinner; 
	Map<Integer, Float > menuMap = new HashMap<>();
	private int valuess=0;
	private List<hangHoa> drinks;
    private List<table> desks;
    private List<JSpinner> mySpinners = new ArrayList<>();
    private table dsban[]= new table[10];
	int width= 207;
	int height= 715;
	
	private float total = (float) 0.0;
    private int x=0;
    private float tax = (float)0.0;
	
	private final JSeparator separator = new JSeparator();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaoDonHang frame = new TaoDonHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TaoDonHang() {
		init();
	}
	public void init() {
		tableRe = new tableRepository();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1360, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		for(int i=0 ; i<dsban.length; i++) {
			dsban[i]= new table();
			dsban[i].setMaBan(i+1);
			dsban[i].setName("BÃ n "+(i+1));
			dsban[i].setTrangthai(TableStatus.FREE);
			if(i%2!=0) {
				dsban[i].setTrangthai(TableStatus.SERVING);
			}
		}
		
		banCF();
//**************************************************************************		
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(128, 255, 0));
		panel.setBounds(0, 38, 206, 715);
		contentPane.add(panel);
		closeMenuBar();
//**************************************************************************		
		
		JButton close = new JButton("");
		close.setBounds(0, 0, 50, 50);
		close.setBackground(new Color(128, 255, 0));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		close.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\cancel_close_delete_exit_logout_remove_x_icon_123217 - Copy.png"));
		panel.add(close);
		
		JButton btnNewButton_3_1 = new JButton("Log Out");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhienLamViecRepository phienLamViecRepository = new PhienLamViecRepository();
				try {
					phienLamViecRepository.deleteById(1);
					dispose();
					loginView view = new loginView();
					view.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3_1.setBounds(0, 655, 207, 60);
		btnNewButton_3_1.setBackground(Color.WHITE);
		panel.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("ThÃ´ng Tin");
		btnNewButton_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3_2.setBackground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				btnNewButton_3_2.setBackground(Color.WHITE);
			}
		});
		btnNewButton_3_2.setBounds(0, 575, 207, 60);
		btnNewButton_3_2.setBackground(Color.WHITE);
		panel.add(btnNewButton_3_2);
		separator.setBounds(0, 0, 0, 715);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(207, 0, 0, 715);
		panel.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		ImageIcon icon = new ImageIcon("C:\\Pic\\2.jpg");
        Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(53, 60, 80, 80);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ThÃ nh Ngá»c Huy");
		PhienLamViecRepository phienLamViecRepository= new PhienLamViecRepository();
		try {
			PhienLamViec sesion= phienLamViecRepository.get(1);
			int manhanvien=sesion.getMaNhanVien();
			System.out.println(manhanvien);
			NhanVienReposity nhanVienReposity = new NhanVienReposity();
			nhanVienModel nhanVienModel= nhanVienReposity.get(manhanvien);
			String tennhanvien= nhanVienModel.getHoten();
			lblNewLabel_2.setText(tennhanvien);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_2.setBounds(10, 150, 171, 35);
			panel.add(lblNewLabel_2);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		JPanel pinfo = new JPanel();
		pinfo.setBounds(0, 38, 206, 715);
		contentPane.add(pinfo);
		
		JButton open = new JButton("");
		open.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\bar-menu_icon-icons.com_70305.png"));
		open.setBackground(new Color(128, 255, 0));
		open.setBounds(0, 0, 50, 50);
		
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			pinfo.setVisible(false);
				openMenuBar();	
			}
		});
		pinfo.setLayout(null);
		pinfo.add(open);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			pinfo.setVisible(true);
				closeMenuBar();	
			}
		});
//**************************************************************************		
		JPanel phead = new JPanel();
		phead.setBackground(new Color(128, 255, 0));
		phead.setBounds(0, 0, 1360, 38);
		contentPane.add(phead);
		phead.setLayout(null);
//**************************************************************************		
		
		
//*****************************************************************************************		
		JButton ban = new JButton("BÃ€N");
		ban.setBackground(new Color(0,255,255));
		ban.setHorizontalAlignment(SwingConstants.CENTER);
		ban.setBorder(new LineBorder(Color.black));
		ban.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ban.setBounds(206, 0, 121, 38);
		phead.add(ban);
		
		JButton menu = new JButton("MENU");
		menu.setBackground(new Color(128,255,0));
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setBorder(new LineBorder(Color.black));
		menu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menu.setBounds(327, 0, 121, 38);
		phead.add(menu);
		
		ban.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ban.setBackground(new Color(0,255,255));
				menu.setBackground(new Color(128,255,0));
				pmenu.setVisible(false);
				pban.setVisible(true);
			}
		});
		menu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ban.setBackground(new Color(128,255,0));
				menu.setBackground(new Color(0,255,255));
				thucdon();
				contentPane.add(pmenu);
				pmenu.setVisible(true);
				pban.setVisible(false);
				
			}
		});
//*****************************************************************************************		
		JLabel ltime = new JLabel("");
		Date date = new Date();
        SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
        SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
        String time = tf.format(date);
        ltime.setText(time.split(" ")[0]+" "+time.split(" ")[1]);
        ltime.setText(df.format(date));
		
		ltime.setHorizontalAlignment(SwingConstants.CENTER);
        ltime.setFont(new Font("Tahoma", Font.ITALIC, 12));
        ltime.setBounds(0, 0, 206, 38);
        phead.add(ltime);
        
        JLabel ltime2 = new JLabel("");
        ltime2.setHorizontalAlignment(SwingConstants.CENTER);
        ltime2.setFont(new Font("Tahoma", Font.ITALIC, 14));
        ltime2.setBounds(486, 0, 164, 38);
        phead.add(ltime2);
        ltime2.setText(tf.format(date));
//*****************************************************************************************		
        
        
//*****************************************************************************************		
	}
	public void thucdon() {
		try {
			int demhh=0;
			hangHoaRepository dao = new hangHoaRepository();
			drinks = dao.getAll();
			GridBagConstraints gbcm= new GridBagConstraints();
	        gbcm.gridx=0; gbcm.gridy=0;
	        gbcm.ipadx=60; gbcm.ipady=20;
	        gbcm.insets= new Insets(2, 2, 2, 2);
	        pmenu= new JPanel();
	        pmenu.setBounds(206, 38, 1140, 715);
	        pmenu.setLayout(null);
	        
	        JPanel pMenu= new JPanel();
	        pMenu.setBounds(0, 0, 844, 715);
	        pmenu.add(pMenu);
	        JPanel pBill= new JPanel();
	        pBill.setBounds(844,0,296,715);
	        pmenu.add(pBill);
	        //contentPane.add(pmenu);
	        JPanel menuarea= new JPanel(new BorderLayout());
	        menuarea.setPreferredSize(new Dimension(844, 715));
	        JPanel allmenu= new JPanel();
	        allmenu.setPreferredSize(new Dimension(844,1000));
	        allmenu.setLayout(new GridBagLayout());
	        JScrollPane scr= new JScrollPane(allmenu);
	        menuarea.add(scr, BorderLayout.CENTER);
	        pMenu.add(menuarea);
	        
	        for(hangHoa drink: drinks) {
	        	demhh+=1;
	        	JPanel item= new JPanel();
	        	item.setPreferredSize(new Dimension(210,70));
	        	item.setLayout(new BorderLayout());
	        	item.setBorder(new LineBorder(Color.BLACK));
	        	JLabel imglb = new JLabel("");
				item.add(imglb, BorderLayout.WEST);
				ImageIcon itemicon = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\tra-hoa-hong-da.png");
				Image itemimg = itemicon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
				
				imglb.setIcon(new ImageIcon(itemimg));
				
				JPanel textinfo= new JPanel();
				textinfo.setLayout(new GridLayout(2,1));
				JLabel name= new JLabel("TrÃ  ÄÃ o Hoa CÃºc");
				name.setFont(new Font("Tahoma", Font.PLAIN, 14));
				name.setHorizontalAlignment(SwingConstants.CENTER);
				JLabel price = new JLabel("14000");
				price.setForeground(Color.orange);
				price.setFont(new Font("Tahoma", Font.PLAIN, 14));
				price.setHorizontalAlignment(SwingConstants.CENTER);
				textinfo.add(name);
				textinfo.add(price);
				
				JPanel soluong = new JPanel();
		       
		        soluong.setLayout(new BorderLayout(0, 0));
		        
		        spinner = new JSpinner();
		        soluong.add(spinner);
		        spinner.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						JSpinner source = (JSpinner) e.getSource();
	                    int value = (Integer) source.getModel().getValue();
	                    handleQuantity(menuMap, drink.getMaHangHoa(), drink.getTenHangHoa(), value, drink.getGiaHangHoa());
	               
					}
				});
				
				item.add(imglb, BorderLayout.WEST);
				item.add(textinfo, BorderLayout.CENTER);
				item.add(soluong, BorderLayout.EAST);
	        	allmenu.add(item, gbcm);
	        	if(demhh%3==0) {
	        		gbcm.gridx=0; gbcm.gridy++;
	        	}else {
	        		gbcm.gridx++;
	        	}
	        }
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	public void banCF() {
        try {
            tableRepository dao = new tableRepository();
            desks = dao.getAll();
            
            pban = new JPanel();
     		pban.setBorder(new LineBorder(new Color(0, 0, 0)));
     		pban.setBounds(206, 38, 1140, 715);
     		contentPane.add(pban);
     		pban.setLayout(null);
     		
    		JPanel pthongtin = new JPanel();
    		pthongtin.setBorder(new LineBorder(new Color(0, 0, 0)));
    		pthongtin.setBounds(690, 0, 450, 715);
    		pban.add(pthongtin);
    		pthongtin.setLayout(null);
    		
    		JLabel lblNewLabel = new JLabel("ThÃ´ng tin chi tiáº¿t");
    		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
    		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    		lblNewLabel.setBounds(166, 10, 141, 31);
    		pthongtin.add(lblNewLabel);
    		
    		JPanel thongtin = new JPanel();
    		thongtin.setBounds(0, 42, 450, 673);
    		pthongtin.add(thongtin);
            
    		JLabel test= new JLabel("haha");
    		test.setHorizontalAlignment(SwingConstants.CENTER);
    		JPanel pcacban = new JPanel();
    		pcacban.setBackground(new Color(0,255,255));
    		pcacban.setBorder(new LineBorder(Color.BLACK));
    		pcacban.setBounds(0, 0, 690, 715);
    		pban.add(pcacban);
    		pcacban.setLayout(new GridBagLayout());
    		
    		GridBagConstraints gbcb= new GridBagConstraints();
    		gbcb.gridx=0; gbcb.gridy=0;
    		gbcb.ipadx= 100; gbcb.ipady=30;
    		gbcb.insets= new Insets(30, 50, 30, 50);
    		
    		for(int i=0; i<10; i++) {
    			JLabel ban= new JLabel("BÃ n "+(i+1));
    			ban.setOpaque(true);
    			ban.setFont(new Font("ARIA", Font.BOLD, 16));
    			ban.setBorder(new LineBorder(Color.black));
    			ban.setHorizontalAlignment(SwingConstants.CENTER);
    			if(dsban[i].getTrangthai()==TableStatus.SERVING) {
    				ban.setBackground(Color.red);
    			}else {
    				ban.setBackground(new Color(0, 255, 255));
    			}
    			ban.addMouseListener(new MouseListener() {
    				public void mouseExited(MouseEvent e) {
    					ban.setBorder(new LineBorder(Color.black));
    					ban.setForeground(Color.black);
    					
    				}

    				public void mouseEntered(MouseEvent e) {
    					ban.setBorder(new LineBorder(Color.BLUE));
    					ban.setForeground(Color.WHITE);
    				}
    				
    				public void mouseClicked(MouseEvent e) {
    					// TODO Auto-generated method stub
    					thongtin.removeAll();
    					thongtin.repaint();
    					String tenban= ban.getText();
    					
    					if(dsban[getIdTbl(tenban)-1].getTrangthai()!= TableStatus.SERVING) {
    						thongtin.setLayout(new GridBagLayout());
    						GridBagConstraints gbco= new GridBagConstraints();
    						gbco.gridx=0; gbco.gridy=0;
    						gbco.insets= new Insets(20,20, 20, 20);
    						thongtin.add(test, gbco); gbco.gridy++;
    						test.setText("BÃ n ChÆ°a ÄÆ°á»£c Sá»­ Dá»¥ng.");
    						test.setFont(new Font("ARIA", Font.BOLD, 20));
    						
    						JButton ordermon= new JButton("Gá»i MÃ³n");
    						ordermon.setBounds(200, 200, 60, 20);
    						ordermon.setFont(new Font("ARIA",  Font.BOLD,  16));
    						ordermon.setBackground(new Color(0, 255, 255));
    						thongtin.add(ordermon, gbco);
    					}else {
    						thongtin.setLayout(new GridBagLayout());
    						GridBagConstraints gbco= new GridBagConstraints();
    						gbco.gridx=0; gbco.gridy=0;
    						gbco.gridwidth=2;
    						gbco.insets= new Insets(20,20, 20, 20);
    						thongtin.add(test, gbco); gbco.gridy++;
    						test.setText("BÃ n Äang ÄÆ°á»£c Sá»­ Dá»¥ng.");
    						test.setFont(new Font("ARIA", Font.BOLD, 20));
    						gbco.gridwidth=1;
    						JButton ordermon= new JButton("ThÃªm MÃ³n");
    						ordermon.setFont(new Font("ARIA",  Font.BOLD,  16));
    						ordermon.setBackground(new Color(0, 255, 255));
    						thongtin.add(ordermon, gbco); gbco.gridx++;
    						
    						JButton payment= new JButton("Thanh ToÃ¡n");
    						payment.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									dsban[getIdTbl(tenban)-1].setTrangthai(TableStatus.FREE);
									pcacban.repaint();
									banCF();
									
								}
							});
    						payment.setFont(new Font("ARIA",  Font.BOLD,  16));
    						payment.setBackground(new Color(0, 255, 255));
    						thongtin.add(payment, gbco);
    					}
    				}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
    			});
    			pcacban.add(ban, gbcb);
    			if(i%2!=0) {
    				gbcb.gridx=0;
    				gbcb.gridy++;
    			}else {
    				gbcb.gridx++;
    			}
    		}
    		
            
            
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
	            JOptionPane.showMessageDialog(jpn_Menu, "Vui lÃ²ng chá»n sá»‘ lÆ°á»£ng");
	            return false;
	        }
	        return true;
	    }
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
	                // CÃ¡ÂºÂ­p nhÃ¡ÂºÂ­t sÃ¡Â»â€˜ lÃ†Â°Ã¡Â»Â£ng mÃƒÂ³n trong bill
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
	            JOptionPane.showMessageDialog(jpn_Menu, "Báº¡n chÆ°a chá»n mÃ³n!");

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
	                JOptionPane.showMessageDialog(jpn_Menu, "Báº¡n chÆ°a thanh toÃ¡n");
	            }
	        } else {
	            JOptionPane.showMessageDialog(jpn_Menu, "Báº¡n chÆ°a mua sáº£n pháº©m nÃ o");
	        }
	    }//GEN-LAST:event_btn_InhoadonActionPerformed
	private void openMenuBar() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for( int i=0;i<height;i++) {
					panel.setSize(width,height);
				}
				
			}
		}).start();
		
	}
	private void closeMenuBar() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for( int i=width;i>0;i--) {
					panel.setSize(i,height);
				}
				
			}
		}).start();
	}
	private int getIdTbl(String x) {
		String[] s= x.split(" ");
		int i= Integer.parseInt(s[1]);
		return i;
	}
	 private tableRepository tableRe;
	private JPanel boxDesk;
    private JPanel boxDrink;
	private JPanel deskCfPanel;
	private javax.swing.JPanel pnlBanCF;
	public JPanel jpn_Menu;
	private JTextField jtfTax;
	private JTextArea textBill;
	private JTextField jTextFieldSubTotal;
    private JTextField jTextFieldTotal;
    private JButton btnTotal;
}
