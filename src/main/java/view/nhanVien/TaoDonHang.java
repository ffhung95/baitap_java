package view.nhanVien;

import java.awt.EventQueue;
import java.awt.FlowLayout;

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
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

//import model.ChiTietHoaDon;
import model.DatHang;
import model.HoaDon;
import model.PhienLamViec;
import model.hangHoa;
import model.nhanVienModel;
import model.table;
//import repository.ChiTietHoaDonRepository;
import repository.datHangRepository;
import repository.NhanVienReposity;
import repository.PhienLamViecRepository;
import repository.hangHoaRepository;
import repository.tableRepository;
import repository.HoaDonRepository;
import utils.TableStatus;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JOptionPane;

public class TaoDonHang extends JFrame {
	private int value = 0;
	private int valuess = 0;
	int width = 207;
	int height = 715;
	int checkclick = 0;
	private float total = (float) 0.0;
	private int x = 0;
	private float tax = (float) 0.0;
	private int soban=0;
	
	private int sohang=0;
	
	private JTable table_Bill;
	private JTable tthientai;
	
	private JLabel ltime;
	private JLabel ltime2;
	
	private JPanel pmenu;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel pban;
	
	private JSpinner spinner;
	private JSpinner spQuantity;
	
	private JButton Jbutton_menu;
	private JButton Jbutton_Ban;
	
	Map<Integer, Float> menuMap = new HashMap<>();
	
	private List<hangHoa> drinks;
	private List<table> desks;
	private List<JSpinner> mySpinners = new ArrayList<>();
	
	private table dsban[] = new table[10];
	private tableRepository tableRe;
	private hangHoaRepository dao;
	private tableRepository tableRepo;
	
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

	public TaoDonHang() {
		pmenu = new JPanel();
		init();
	}

	public void init() {
		tableRe = new tableRepository();
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1360, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTime();
		//////////////////////////////////////////////////////
		dao = new hangHoaRepository();
		try {
			drinks = dao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//////////////////////////////////////////////////////
		tableRepo = new tableRepository();
		try {
			desks = tableRepo.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//////////////////////////////////////////////////////
		for(table cnt: desks) {
			soban++;
		}
		for(hangHoa cnt: drinks) {
			sohang++;
		}
		//////////////////////////////////////////////////////
		banCF(0);
//**************************************************************************		

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 38, 206, 715);
		contentPane.add(panel);
		closeMenuBar();
//**************************************************************************		

		JButton close = new JButton("");
		close.setBounds(0, 0, 50, 50);
		close.setBackground(new Color(255, 255, 255));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		close.setIcon(new ImageIcon(
				"C:\\btl\\baitap_java\\src\\main\\resources\\images\\cancel_close_delete_exit_logout_remove_x_icon_123217 - Copy.png"));
		panel.add(close);

		JButton btnNewButton_3_1 = new JButton("Log Out");
		btnNewButton_3_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3_1.setBackground(new Color(255, 255, 255));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3_1.setBackground(new Color(0, 255, 255));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhienLamViecRepository phienlamviecRepo= new PhienLamViecRepository();
				try {
					phienlamviecRepo.deleteById(1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				contentPane.removeAll();
				dispose();
				new loginView();
			}
		});
		btnNewButton_3_1.setBounds(0, 655, 207, 60);
		btnNewButton_3_1.setBackground(Color.WHITE);
		panel.add(btnNewButton_3_1);
		separator.setBounds(0, 0, 0, 715);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(207, 0, 0, 715);
		panel.add(separator_1);

		JLabel lblNewLabel_1 = new JLabel("New label");
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(53, 60, 100, 100);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		PhienLamViecRepository phienLamViecRepository = new PhienLamViecRepository();
		NhanVienReposity nhanvienRe = new NhanVienReposity();
		try {
			PhienLamViec session = phienLamViecRepository.get(1);
			nhanVienModel nhanvien = nhanvienRe.get(session.getNhanvien().getManv());
			if(nhanvien.getAvt()==null) {
				ImageIcon icon = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\non_user.jpg");
				Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				lblNewLabel_1.setIcon(new ImageIcon(img));
			}
			lblNewLabel_2.setText(nhanvien.getHoten());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 170, 171, 35);
		panel.add(lblNewLabel_2);

		JPanel pinfo = new JPanel();
		pinfo.setBounds(0, 38, 206, 715);
		contentPane.add(pinfo);

		JButton open = new JButton("");
		open.setIcon(
				new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\bar-menu_icon-icons.com_70305.png"));
		open.setBackground(new Color(255, 255, 255));
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
		phead.setBackground(new Color(128, 0, 255));
		phead.setBounds(0, 0, 1360, 38);
		contentPane.add(phead);
		phead.setLayout(null);
//**************************************************************************		

//*****************************************************************************************		
		Jbutton_Ban = new JButton("BÀN");
		Jbutton_Ban.setForeground(new Color(255, 255, 128));
		Jbutton_Ban.setBackground(new Color(255, 0, 128));
		Jbutton_Ban.setHorizontalAlignment(SwingConstants.CENTER);
		Jbutton_Ban.setBorder(new LineBorder(Color.black));
		Jbutton_Ban.setFont(new Font("Tahoma", Font.BOLD, 16));
		Jbutton_Ban.setBounds(206, 0, 121, 38);
		phead.add(Jbutton_Ban);

		Jbutton_menu = new JButton("MENU");
		Jbutton_menu.setForeground(new Color(255, 255, 128));
		Jbutton_menu.setBackground(new Color(128, 0, 255));
		Jbutton_menu.setHorizontalAlignment(SwingConstants.CENTER);
		Jbutton_menu.setBorder(new LineBorder(Color.black));
		Jbutton_menu.setFont(new Font("Tahoma", Font.BOLD, 16));
		Jbutton_menu.setBounds(327, 0, 121, 38);
		phead.add(Jbutton_menu);

		Jbutton_Ban.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (checkclick == 1) {
					pmenu.setVisible(false);
					pban.setVisible(true);
					Jbutton_Ban.setBackground(new Color(255, 0, 128));
					Jbutton_Ban.setForeground(Color.YELLOW);
					Jbutton_menu.setBackground(new Color(128, 0, 255));
					Jbutton_menu.setForeground(new Color(255, 255, 128));

				}
				checkclick = 0;
			}
		});
		Jbutton_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkclick == 0) {
					Jbutton_Ban.setBackground(new Color(128, 0, 255));
					Jbutton_Ban.setForeground(new Color(255, 255, 128));
					Jbutton_menu.setForeground(Color.yellow);
					Jbutton_menu.setBackground(new Color(255, 0, 128));
					
					pban.setVisible(false);
					thucdon(0);
				}
				checkclick = 1;

			}
		});
//*****************************************************************************************		
		ltime = new JLabel("");
		ltime.setBackground(new Color(255, 255, 255));
		ltime.setForeground(new Color(255, 255, 128));
		ltime.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
		ltime.setHorizontalAlignment(SwingConstants.CENTER);
		ltime.setLocation(1144, 0);
		ltime.setSize(206, 38);
		ltime2 = new JLabel();
		ltime2.setForeground(new Color(255, 255, 128));
		ltime2.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
		ltime2.setHorizontalAlignment(SwingConstants.CENTER);
		ltime2.setLocation(1016, 0);
		ltime2.setSize(141, 38);
		phead.add(ltime);
		phead.add(ltime2);
//*****************************************************************************************		

//*****************************************************************************************		
	}

	public void thucdon(int idb) {
		try {
			int hanghoa=0;
			GridBagConstraints gbcm = new GridBagConstraints();
			gbcm.gridx = 0;
			gbcm.gridy = 0;
			gbcm.ipadx = 60;
			gbcm.ipady = 20;
			gbcm.insets = new Insets(2, 2, 2, 2);
			pmenu = new JPanel();
			pmenu.setBounds(206, 38, 1140, 715);
			pmenu.setLayout(null);
			//////////////////////////////////////////////////////////////////
			JPanel pMenu = new JPanel();
			pMenu.setBounds(0, 0, 1140, 415);
			pmenu.add(pMenu);
			//////////////////////////////////////////////////////////////////
			JPanel pBill = new JPanel();
			pBill.setBounds(0, 415, 1140, 300);
			pBill.setLayout(null);
			pmenu.add(pBill);
			contentPane.add(pmenu);
			//////////////////////////////////////////////////////////////////
			JPanel panel_Bill= new JPanel();
			panel_Bill.setBounds(0,0,840,300);
			panel_Bill.setLayout(new BorderLayout());
			table_Bill = new JTable();
			table_Bill.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Id", "Tên bàn", "Tên món", "Tên nhân viên", "Số lượng", "Thành tiền" }));
			
			JScrollPane scroll_Bill = new JScrollPane();
			scroll_Bill.setViewportView(table_Bill);
			panel_Bill.add(scroll_Bill, BorderLayout.CENTER);
			
			pBill.add(panel_Bill);
			//////////////////////////////////////////////////////////////////
			
			JPanel panel_Total= new JPanel();
			panel_Total.setBorder(new LineBorder(Color.black));
			panel_Total.setBounds(840,0,300,300);
			pBill.add(panel_Total);
			
			panel_Total.setLayout(new GridBagLayout());
			GridBagConstraints gbct= new GridBagConstraints();
			gbct.gridx=0; gbct.gridy=0;
			gbct.insets= new Insets(10, 10, 10, 10);
			
			JLabel l_soban= new JLabel("Bàn: "+ idb);
			l_soban.setFont(new Font("ARIA",  Font.BOLD, 20));
			JLabel l_tongtien= new JLabel("Tổng Tiền: ");
			l_tongtien.setFont(new Font("ARIA", Font.BOLD, 20));
			l_tongtien.setHorizontalAlignment(SwingConstants.CENTER);
			JLabel l_sotien= new JLabel("0.0");
			l_sotien.setHorizontalAlignment(SwingConstants.LEFT);
			l_sotien.setFont(new Font("ARIA", Font.ITALIC, 20));
			l_sotien.setForeground(Color.red);
			JButton l_thanhtoan= new JButton("Thanh Toán");
			
			gbct.gridwidth=2;
			panel_Total.add(l_soban, gbct); gbct.gridy++; gbct.gridwidth=1;
			panel_Total.add(l_tongtien, gbct); gbct.gridx++;
			panel_Total.add(l_sotien, gbct); gbct.gridy++; gbct.gridx=0; gbct.gridwidth=2;
			panel_Total.add(l_thanhtoan, gbct);
			pBill.add(panel_Total);
			//////////////////////////////////////////////////////////////////
			JPanel menuarea = new JPanel(new BorderLayout());
			menuarea.setPreferredSize(new Dimension(1140, 415));
			
			JPanel allmenu = new JPanel();
			allmenu.setLayout(new GridBagLayout());
			
			
			GridBagConstraints gbcmn= new GridBagConstraints();
			gbcmn.gridx=0; gbcmn.gridy=0;
			gbcmn.ipadx=90; gbcmn.ipady=10;
			gbcmn.insets= new Insets(2, 2, 2, 2);
			
			allmenu.setPreferredSize(new Dimension(1140, 150*(sohang/4+1)));
			
			System.out.println(sohang);
			for (hangHoa drink : drinks) {
				hanghoa++;
				boxDrink = new JPanel();
				boxDrink.setBorder(new LineBorder(Color.black));
				boxDrink.setLayout(new BorderLayout());
				
				JPanel text= new JPanel();
				text.setLayout(new GridLayout(0,1));
				JLabel nameLbl = new JLabel(" " + drink.getTenHangHoa());
				nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
				JLabel priceLbl = new JLabel(" " + drink.getGiaHangHoa() + " VND");
				priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
				text.add(nameLbl);
				text.add(priceLbl);
				
				JLabel imageLbl = new JLabel();
				byte[] bytes = (byte[]) drink.getAnhHangHoa();
				ImageIcon icon = new ImageIcon(bytes);
				Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				imageLbl.setIcon(new ImageIcon(img));
				
				JPanel quantityPnl = new JPanel();
				quantityPnl.setPreferredSize(new Dimension(80,30));
				quantityPnl.setLayout(new GridLayout(3,1));
				JLabel quantityLbl = new JLabel("Số lượng");
				quantityLbl.setHorizontalAlignment(SwingConstants.CENTER);
				SpinnerNumberModel model = new SpinnerNumberModel(0, 0, drink.getSoLuong(), 1);
				spQuantity = new JSpinner(model);
				spQuantity.setMaximumSize(new Dimension(60, spQuantity.getPreferredSize().height));
				mySpinners.add(spQuantity);
				JLabel Jlabel_Chon = new JLabel("Chọn");
				Jlabel_Chon.setOpaque(true);
				Jlabel_Chon.setBorder(new LineBorder(Color.black));
				Jlabel_Chon.setBackground(new Color(0, 255,255));
				Jlabel_Chon.setHorizontalAlignment(SwingConstants.CENTER);
				Jlabel_Chon.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						datHangRepository datHangRepository = new datHangRepository();
						DatHang datHang = new DatHang();
						PhienLamViecRepository phienLamViecRepository = new PhienLamViecRepository();
						try {
							PhienLamViec session = phienLamViecRepository.get(1);
							table bantam= new table();
							bantam.setMaBan(idb);
							datHang.setBan(bantam);
							datHang.setNhanvien(session);
							datHang.setHanghoa(drink);
							datHang.setSoLuong(value);
							float thanhtien = drink.getGiaHangHoa() * value;
							datHang.setThanhTien(thanhtien);
							datHangRepository.save(datHang);
							JOptionPane.showMessageDialog(null, "Đăt món thành công");
							float tmp= Float.parseFloat(l_sotien.getText());
							l_sotien.setText(" "+(thanhtien+tmp));
							loadtabel(idb);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				quantityPnl.add(quantityLbl);
				quantityPnl.add(spQuantity);
				quantityPnl.add(Jlabel_Chon);
				boxDrink.add(imageLbl, BorderLayout.WEST);
				boxDrink.add(text, BorderLayout.NORTH);
				boxDrink.add(quantityPnl, BorderLayout.EAST);
				allmenu.add(boxDrink, gbcmn);
				if(hanghoa%4==0) {
					gbcmn.gridx=0; gbcmn.gridy++;
				}else {
					gbcmn.gridx++;
				}
				spQuantity.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent e) {
						JSpinner source = (JSpinner) e.getSource();
						value = (Integer) source.getModel().getValue();
					}
				});
			}
			JScrollPane scr = new JScrollPane(allmenu);
			
			menuarea.add(scr, BorderLayout.CENTER);
			pMenu.add(menuarea);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void banCF(int idb) {
		try {
			pban = new JPanel();
			pban.setBorder(new LineBorder(new Color(0, 0, 0)));
			pban.setBounds(206, 38, 1140, 715);
			contentPane.add(pban);
			pban.setLayout(new BorderLayout());

			JPanel pthongtin = new JPanel();
			pthongtin.setBorder(new LineBorder(new Color(0, 0, 0)));
			pthongtin.setPreferredSize(new Dimension(450, 715));
			pban.add(pthongtin, BorderLayout.EAST);
			pthongtin.setLayout(null);

			JLabel lblNewLabel = new JLabel("Thông tin chi tiết");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(166, 10, 141, 31);
			pthongtin.add(lblNewLabel);

			JPanel thongtin = new JPanel();
			thongtin.setBounds(0, 42, 450, 673);
			pthongtin.add(thongtin);

			JLabel test = new JLabel("");
			test.setHorizontalAlignment(SwingConstants.CENTER);
			
			JPanel pcacban = new JPanel();
			pcacban.setPreferredSize(new Dimension(690, 715));
			JScrollPane scrcacban= new JScrollPane(pcacban);
			pcacban.setBackground(new Color(255, 255, 255));
			pcacban.setBorder(new LineBorder(Color.BLACK));
			pban.add(scrcacban, BorderLayout.CENTER);
			pcacban.setLayout(new GridBagLayout());

			GridBagConstraints gbcb = new GridBagConstraints();
			gbcb.gridx = 0;
			gbcb.gridy = 0;
			gbcb.ipadx = 100;
			gbcb.ipady = 30;
			gbcb.insets = new Insets(30, 40, 30, 40);
			if(soban>18) {
				pcacban.setPreferredSize(new Dimension(690, 110*(soban/3+1)));
			}else {
				pcacban.setPreferredSize(new Dimension(690, 715));
			}
			System.out.println(soban);
			for (table ban : desks) {
				JLabel Jlbel_ban = new JLabel();
				Jlbel_ban.setText(ban.getName());
				Jlbel_ban.setOpaque(true);
				Jlbel_ban.setFont(new Font("ARIA", Font.BOLD, 16));
				Jlbel_ban.setBorder(new LineBorder(Color.black));
				Jlbel_ban.setHorizontalAlignment(SwingConstants.CENTER);
				if (ban.getTrangthai() == TableStatus.SERVING) {
					Jlbel_ban.setBackground(Color.red);
				} else {
					Jlbel_ban.setBackground(new Color(0, 255, 255));
				}
				Jlbel_ban.addMouseListener(new MouseListener() {
					public void mouseExited(MouseEvent e) {
						Jlbel_ban.setBorder(new LineBorder(Color.black));
						Jlbel_ban.setForeground(Color.black);
					}

					public void mouseEntered(MouseEvent e) {
						Jlbel_ban.setBorder(new LineBorder(Color.BLUE));
						Jlbel_ban.setForeground(Color.WHITE);
					}

					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						thongtin.removeAll();
						thongtin.repaint();
						String tenban = Jlbel_ban.getText();
						lblNewLabel.setText(tenban);
						lblNewLabel.setFont(new Font("Aria",  Font.BOLD,  30));
						if (ban.getTrangthai() != TableStatus.SERVING) {
							thongtin.setLayout(new GridBagLayout());
							GridBagConstraints gbco = new GridBagConstraints();
							gbco.gridx = 0;
							gbco.gridy = 0;
							gbco.insets = new Insets(20, 20, 20, 20);
							thongtin.add(test, gbco);
							gbco.gridy++;
							test.setText("Bàn chưa được sử dụng.");
							test.setFont(new Font("ARIA", Font.BOLD, 20));

							JButton ordermon = new JButton("Gọi món");
							ordermon.addActionListener(new ActionListener() {
								int maban = ban.getMaBan();

								@Override
								public void actionPerformed(ActionEvent e) {

									/// dispose();
									if (checkclick == 0) {
										ban.setTrangthai(TableStatus.SERVING);
										try {
											tableRepo.update(ban);
											for (table ban : desks) {
												if(Jlbel_ban.getText().equals(ban.getName())) {
													Jlbel_ban.setBackground(Color.red);
												}
											}
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										Jbutton_Ban.setBackground(new Color(128, 255, 0));
										Jbutton_menu.setBackground(new Color(0, 255, 255));

										pban.setVisible(false);
										thucdon(maban);
									}
									checkclick = 1;

								}
							});
							// ordermon.setBounds(200, 200, 60, 20);
							ordermon.setFont(new Font("ARIA", Font.BOLD, 16));
							ordermon.setBackground(new Color(0, 255, 255));
							thongtin.add(ordermon, gbco);
						} else {
							thongtin.setLayout(new BorderLayout());
							thongtin.add(test, BorderLayout.NORTH);
							//test.setText(Jlbel_ban.getText());
							test.setFont(new Font("ARIA", Font.BOLD, 20));
							
							JPanel panel_tthientai= new JPanel();
							panel_tthientai.setLayout(new BorderLayout());
							tthientai = new JTable();
							tthientai.setModel(new DefaultTableModel(new Object[][] {},
									new String[] {"Tên món","Số lượng"}));
							loadthongtin(getIdTbl(Jlbel_ban.getText()));
							JScrollPane scroll_tthientai = new JScrollPane();
							scroll_tthientai.setViewportView(tthientai);
							panel_tthientai.add(scroll_tthientai, BorderLayout.CENTER);
							panel_tthientai.add(scroll_tthientai, BorderLayout.CENTER);
							
							thongtin.add(panel_tthientai, BorderLayout.CENTER);
							
							JPanel button_order= new JPanel();
							JButton ordermon = new JButton("Thêm món");
							ordermon.setFont(new Font("ARIA", Font.BOLD, 16));
							ordermon.setBackground(new Color(0, 255, 255));
							button_order.add(ordermon);
							JButton payment = new JButton("Thanh toán");
							payment.setFont(new Font("ARIA", Font.BOLD, 16));
							payment.setBackground(new Color(0, 255, 255));
							button_order.add(payment);

							thongtin.add(button_order, BorderLayout.SOUTH);
							
							ordermon.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									if (checkclick == 0) {
										ban.setTrangthai(TableStatus.SERVING);
										try {
											tableRepo.update(ban);
											for (table ban : desks) {
												if (Jlbel_ban.getText().equals(ban.getName())) {
													Jlbel_ban.setBackground(Color.red);
												}
											}
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										Jbutton_Ban.setBackground(new Color(128, 255, 0));
										Jbutton_menu.setBackground(new Color(0, 255, 255));
										pban.setVisible(false);
										int idban = ban.getMaBan();
										thucdon(idban);
									}
									checkclick = 1;
								}
							});
							
							payment.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									tableRepository tmp = new tableRepository();

									ban.setTrangthai(TableStatus.FREE);
									try {
										tmp.update(ban);
										for (table ban : desks) {
											if(Jlbel_ban.getText().equals(ban.getName())) {
												Jlbel_ban.setBackground(new Color(0, 255, 255));
												
											}
										}
										
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									int idban=ban.getMaBan();
									float tongtien=0;
									datHangRepository datHangRepository = new datHangRepository();
									try {
										for (DatHang dathang : datHangRepository.getAll()) {
											if (dathang.getBan().getMaBan() == idban) {
												tongtien = tongtien + dathang.getThanhTien();
												datHangRepository.delete(dathang);
											}
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									HoaDon hoaDon = new HoaDon();

									table bantam= new table();
									bantam.setMaBan(idban);
									hoaDon.setBan(bantam);
									table bantam1= new table();
									bantam1.setMaBan(idban);
									hoaDon.setBan(bantam1);


									hoaDon.setTongTien(tongtien);
									
									try {
										HoaDonRepository hoaDonRepository = new HoaDonRepository();
										hoaDonRepository.save(hoaDon);
										table tablechange = tableRe.get(idban);
										tablechange.setTrangthai(TableStatus.FREE);
										tableRe.update(tablechange);
										Jlbel_ban.setBackground(new Color(0, 255, 255));
										JOptionPane.showMessageDialog(null, "Thanh toán thành công");
										thongtin.removeAll();
										thongtin.repaint();
										loadtabel(idban);
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							});
						}
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseReleased(MouseEvent e) {

					}
				});
				pcacban.add(Jlbel_ban, gbcb);
				if (ban.getMaBan() % 3 == 0) {
					gbcb.gridx = 0;
					gbcb.gridy++;
				} else {
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
		textBill.append("Sunshine\n" + "Time: " + formattedTime + "\n" + "Date: " + formattedDate + "\n"
				+ "**********************************************\n" + "Item Name: \t\t\t" + "Gia: \n");

	}

	
	
	private void openMenuBar() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < height; i++) {
					panel.setSize(width, height);
				}
			}
		}).start();
	}

	private void closeMenuBar() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = width; i > 0; i--) {
					panel.setSize(i, height);
				}

			}
		}).start();
	}

	private int getIdTbl(String x) {
		String[] s = x.split(" ");
		int i = Integer.parseInt(s[1]);
		return i;
	}
	public void setTime() {
        new Thread(new Runnable() {
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
                    ltime2.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    ltime.setText(df.format(date));
                }
            }
        }).start();
    }
	private void loadtabel(int idban) {
		datHangRepository dathangReposity = new datHangRepository();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Tên bàn");
		defaultTableModel.addColumn("Tên nhân viên");
		defaultTableModel.addColumn("Tên món");
		defaultTableModel.addColumn("Số lượng");
		defaultTableModel.addColumn("Thành Tiền");

		try {
			for (DatHang dathang : dathangReposity.getAll()) {
				NhanVienReposity nvRe= new NhanVienReposity();
				nhanVienModel nhanvien =nvRe.get(1);
				if(dathang.getBan().getMaBan()==idban) {
					defaultTableModel.addRow(new Object[] {
							 dathang.getMaDatHang(),dathang.getBan().getName(),dathang.getHanghoa().getTenHangHoa()
								,dathang.getNhanvien().getNhanvien().getHoten(),dathang.getSoLuong(),dathang.getThanhTien()
					});
					table_Bill.setModel(defaultTableModel);
					table_Bill.getTableHeader().setReorderingAllowed(false);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void loadthongtin(int idban) {
		datHangRepository dathangReposity = new datHangRepository();
		DefaultTableModel defaultTableModel = new DefaultTableModel();

		defaultTableModel.addColumn("Tên món");
		defaultTableModel.addColumn("Số lượng");

		try {
			for (DatHang dathang : dathangReposity.getAll()) {
				if(dathang.getBan().getMaBan()==idban) {
					defaultTableModel.addRow(new Object[]{dathang.getHanghoa().getTenHangHoa(), dathang.getSoLuong()});
					tthientai.setModel(defaultTableModel);
					tthientai.getTableHeader().setReorderingAllowed(false);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
