    package view.admin;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.hangHoaController;
import controller.loaiHangController;
import model.Admin;
import model.hangHoa;
import model.loaiHang;
import repository.AdminReposity;
import repository.hangHoaRepository;
import repository.loaiHangHoaRepository;
import repository.tableRepository;
import view.trangChu.hangHoaView;
import view.trangChu.loaiHangView;
import view.trangChu.tableView;
import view.trangChu.themDonHangView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;

public class HangHoaAdminView extends JPanel {
	private loaiHangHoaRepository loaihangrepository;
	loaiHangHoaRepository LoaiHangRepo;
	private AdminReposity adminrepository;
	private loaiHangController loaiHangCon;
	private hangHoaController hangHoaCon;
	private loaiHangView loaiHangview;
	private hangHoaView hangHoaVi;
	private JTextField textField_timkiem;
	private DefaultTableModel defaultTableModel;
	private JTable table;
	private JTable tableLoaiHang;
	private JTable tableBan;
	public File file;
	private JPanel panel; 
	private JTextField tenmonTF;
	private JTextField giaTF;
	private JTextField soluongTF;
	private JPanel picpanel;
	private JTable table_ban;
	private DefaultComboBoxModel<loaiHang> foodCategoryComboBoxModel = new DefaultComboBoxModel<>();
	public HangHoaAdminView() {
		this.init();
		this.setVisible(true);
		
	}

	private void init() {
		this.setSize(1062, 703);
		panel = new JPanel();
		panel.setBackground(new Color(236, 255, 255));
		panel.setBounds(0, 0, 1062, 703);
		panel.setLayout(null);
		LoaiHangRepo = new loaiHangHoaRepository();
		textField_timkiem = new JTextField();
		textField_timkiem.setBounds(447, 14, 400, 27);
		panel.add(textField_timkiem);
		textField_timkiem.setColumns(10);

//		JLabel lblNewLabel = new JLabel("Tìm kiếm");
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblNewLabel.setBounds(860, 14, 89, 27);
//		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tensanpham = textField_timkiem.getText();
				hangHoaRepository HangHoaRepository = new hangHoaRepository();
				hangHoa HangHoa = new hangHoa();
				HangHoa.setTenHangHoa(tensanpham);
				try {
						List<hangHoa> list = HangHoaRepository.searchByName(tensanpham);

						if (list != null) {
							defaultTableModel.setRowCount(0);
						for (hangHoa hanghoa :list ) {
								defaultTableModel
								.addRow(hanghoa.toRowTable());
						table.setModel(defaultTableModel);
						table.getTableHeader().setReorderingAllowed(false);
	
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(860, 14, 89, 27);
		panel.add(btnNewButton);
//*****Button*********************************************************
//		JPanel panel_1 = new JPanel();
//		panel_1.setBorder(null);
//		panel_1.setBackground(new Color(236, 255, 255));
//		panel_1.setBounds(10, 10, 185, 443);
//		panel.add(panel_1);
//		panel_1.setLayout(null);
//
//		JButton btnThmLoiHng = new JButton("Thêm loại sản phẩm");
//		btnThmLoiHng.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				loaiHangCon.add(loaiHangview);
//
//			}
//		});
//		btnThmLoiHng.setBounds(0, 210, 175, 39);
//		panel_1.add(btnThmLoiHng);
//
//		JButton btnngXut = new JButton("Thoát");
//		btnngXut.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				trangChuAdmin trangchuview = new trangChuAdmin();
//				trangchuview.setVisible(true);
//			}
//		});
//		btnngXut.setBounds(0, 0, 97, 47);
//		panel_1.add(btnngXut);
//
//		JButton btnThmSnPhm = new JButton("Sản phẩm");
//		btnThmSnPhm.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				hangHoaCon.add(hangHoaVi);
//			}
//		});
//		btnThmSnPhm.setBounds(0, 272, 175, 39);
//		panel_1.add(btnThmSnPhm);

//		JSeparator separator_1 = new JSeparator();
//		separator_1.setBorder(new MatteBorder(3, 1, 1, 1, (Color) new Color(0, 0, 0)));
//		separator_1.setBounds(0, 339, 185, 2);
//		panel_1.add(separator_1);

//		JSeparator separator_1_1 = new JSeparator();
//		separator_1_1.setBorder(new MatteBorder(3, 1, 1, 1, (Color) new Color(0, 0, 0)));
//		separator_1_1.setBounds(0, 160, 185, 2);
//		panel_1.add(separator_1_1);

//		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\coffeeAdmin128.png"));
//		lblNewLabel_1.setBounds(24, 60, 151, 126);
//		panel_1.add(lblNewLabel_1);

		JButton btnHy = new JButton("HỦY");
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_timkiem.setText("");
				loadtable();
			}
		});
		btnHy.setBounds(960, 14, 89, 27);
		panel.add(btnHy);

		
	
//********Table****************************************************************************
		JPanel Tab= new JPanel();
			Tab.setBounds(28, 160, 1062, 543);
			Tab.setLayout(null);
			panel.add(Tab);
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(0, 0, 656, 533);
	Tab.add(scrollPane);

	table = new JTable();
	scrollPane.setViewportView(table);
	loadtable();
	setLayout(null);
	this.add(panel);
	
	JPanel LoaiHangTblAll= new JPanel();
	LoaiHangTblAll.setBounds(657, 0, 378, 543);
	LoaiHangTblAll.setLayout(null);
	JPanel LoaiHangTbl = new JPanel();
	LoaiHangTbl.setBorder(new LineBorder(new Color(0, 0, 0)));
	LoaiHangTbl.setBounds(0, 0, 378, 543);
	LoaiHangTblAll.add(LoaiHangTbl);
	Tab.add(LoaiHangTblAll);
	LoaiHangTbl.setLayout(null);
	
	JPanel BanArea= new JPanel();
	BanArea.setBounds(657, 0, 378, 533);
	BanArea.setLayout(null);
		JPanel bantable= new JPanel();
		bantable.setLayout(null);
			bantable.setBounds(10, 5, 378, 400);
			table_ban= new JTable();
			JScrollPane scr_ban= new JScrollPane(table_ban);
			scr_ban.setBounds(0, 0, 356, 390);
			bantable.add(scr_ban);
			BanArea.add(bantable);
			loadtable_ban();
	//Tab.add(BanArea);
	
	JButton btnNewButton_3 = new JButton("Thêm Bàn");
	btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tableView tbv= new tableView();
			tbv.setVisible(true);
		}
	});
	btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnNewButton_3.setBounds(10, 433, 151, 36);
	BanArea.add(btnNewButton_3);
	
	JButton btnNewButton_3_1 = new JButton("Xóa Bàn");
	btnNewButton_3_1.setBounds(217, 434, 151, 36);
	BanArea.add(btnNewButton_3_1);
	JLabel tenmonlbl = new JLabel("Tên Món");
	tenmonlbl.setHorizontalAlignment(SwingConstants.CENTER);
	tenmonlbl.setFont(new Font("Tahoma", Font.BOLD, 13));
	tenmonlbl.setBounds(44, 22, 88, 29);
	LoaiHangTbl.add(tenmonlbl);
	
	JLabel gialbl = new JLabel("Giá");
	gialbl.setHorizontalAlignment(SwingConstants.CENTER);
	gialbl.setFont(new Font("Tahoma", Font.BOLD, 13));
	gialbl.setBounds(44, 72, 88, 29);
	LoaiHangTbl.add(gialbl);
	
	JLabel soluonglbl = new JLabel("Số Lượng");
	soluonglbl.setHorizontalAlignment(SwingConstants.CENTER);
	soluonglbl.setFont(new Font("Tahoma", Font.BOLD, 13));
	soluonglbl.setBounds(44, 122, 88, 29);
	LoaiHangTbl.add(soluonglbl);
	
	JLabel hinhanhlbl = new JLabel("Hình Ảnh");
	hinhanhlbl.setHorizontalAlignment(SwingConstants.CENTER);
	hinhanhlbl.setFont(new Font("Tahoma", Font.BOLD, 13));
	hinhanhlbl.setBounds(44, 172, 88, 29);
	LoaiHangTbl.add(hinhanhlbl);
	
	JLabel loailbl = new JLabel("Loại");
	loailbl.setHorizontalAlignment(SwingConstants.CENTER);
	loailbl.setFont(new Font("Tahoma", Font.BOLD, 13));
	loailbl.setBounds(10, 372, 88, 29);
	LoaiHangTbl.add(loailbl);
	
	tenmonTF = new JTextField();
	tenmonTF.setBounds(191, 26, 151, 23);
	LoaiHangTbl.add(tenmonTF);
	tenmonTF.setColumns(10);
	
	giaTF = new JTextField();
	giaTF.setColumns(10);
	giaTF.setBounds(191, 76, 151, 23);
	LoaiHangTbl.add(giaTF);
	
	soluongTF = new JTextField();
	soluongTF.setColumns(10);
	soluongTF.setBounds(191, 126, 151, 23);
	LoaiHangTbl.add(soluongTF);
	
	JLabel lblNewLabel_2 = new JLabel("vnd");
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
	lblNewLabel_2.setBounds(340, 81, 45, 13);
	LoaiHangTbl.add(lblNewLabel_2);
	
	JButton btnNewButton_2 = new JButton("Chọn");
	btnNewButton_2.setBounds(191, 177, 85, 21);
	LoaiHangTbl.add(btnNewButton_2);
	
	picpanel = new JPanel();
	picpanel.setBounds(140, 208, 151, 151);
	LoaiHangTbl.add(picpanel);
	
//	private void comboboxloaihang(hangHoaView view) {
//		try {
//			for (loaiHang loaihang : LoaiHangRepo.getAll()) {
//				view.getFoodCategoryComboBoxModel().addElement(loaihang);
//			}
//			for(Admin ADMIN :adminrepository.getAdmin()) {
//				view.getAdminComboBoxModel().addElement(ADMIN);
//			}
//		} catch (Exception e) {
//		}
//	}
	JComboBox loaiCB = new JComboBox();
	loaiCB.setModel(foodCategoryComboBoxModel);
	loaiCB.setBounds(108, 373, 151, 29);
	LoaiHangTbl.add(loaiCB);
	
	
	try {
		for (loaiHang loaihang : LoaiHangRepo.getAll()) {
			foodCategoryComboBoxModel.addElement(loaihang);
		}
		
	} catch (Exception e) {
	}
	
	JButton ConfirmBut = new JButton("Xác Nhận");
	ConfirmBut.setFont(new Font("Tahoma", Font.BOLD, 14));
	ConfirmBut.setBounds(25, 425, 107, 47);
	LoaiHangTbl.add(ConfirmBut);
	
	JButton CancelBut = new JButton("Hủy Bỏ");
	CancelBut.setFont(new Font("Tahoma", Font.BOLD, 14));
	CancelBut.setBounds(261, 425, 107, 47);
	LoaiHangTbl.add(CancelBut);
	
	JButton btnNewButton_4 = new JButton("Thêm");
	btnNewButton_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			loaiHangView lhv= new loaiHangView();
			lhv.setVisible(true);
			
			LoaiHangTblAll.removeAll();
			LoaiHangTblAll.add(LoaiHangTbl);
			
		}
	});
	btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
	btnNewButton_4.setBounds(269, 377, 85, 21);
	LoaiHangTbl.add(btnNewButton_4);
	
	JLabel lblNewLabel = new JLabel("Thêm Món");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblNewLabel.setBackground(new Color(240, 240, 240));
	lblNewLabel.setBounds(606, 51, 113, 27);
	panel.add(lblNewLabel);
	
	JButton btnNewButton_1 = new JButton("<");
	btnNewButton_1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			lblNewLabel.setText("Thêm Món");
			//Tab.remove(BanArea);
			Tab.removeAll();
			Tab.repaint();
			Tab.add(scrollPane);
			Tab.add(LoaiHangTblAll);
			
			
		}
	});
	btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnNewButton_1.setBounds(575, 49, 30, 30);
	panel.add(btnNewButton_1);
	
	JButton btnNewButton_1_1 = new JButton(">");
	btnNewButton_1_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			lblNewLabel.setText("Bàn");
			//Tab.remove(LoaiHangTbl);
			Tab.removeAll();
			Tab.repaint();
			Tab.add(scrollPane);
			
			Tab.add(BanArea);
			loadtable_ban();
			//Tab.setVisible(true);
			
		}
	});
	btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnNewButton_1_1.setBounds(719, 51, 30, 30);
	panel.add(btnNewButton_1_1);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(28, 14, 197, 136);
	panel.add(panel_1);
	//////////////////////////////////////////////////
	
	
	
	
	////////////////////////////////////////////////
	ConfirmBut.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			hangHoa foodItem = new hangHoa();
			hangHoaRepository HangHoaRepo = new hangHoaRepository();
			int soluong = Integer.valueOf(soluongTF.getText());
			loaiHang selectCategory = (loaiHang) loaiCB.getSelectedItem();
			System.out.print(selectCategory.getMaloaihang());
			//Admin selectAdmin = (Admin) view.getComboBox_tenquanli().getSelectedItem();
			String name = tenmonTF.getText(), unitPrice = giaTF.getText();
			if (name.isEmpty() || unitPrice.isEmpty() || selectCategory == null) {
			
			}
			if (soluong >= 0) {
				foodItem.setTenHangHoa(name);
				foodItem.setSoLuong(soluong);
				foodItem.setGiaHangHoa(Integer.parseInt(unitPrice));
				try {
					foodItem.setAnhHangHoa(Files.readAllBytes(filepic.toPath()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				loaiHang hangtam = new loaiHang();
				int mahangtam=selectCategory.getMaloaihang();
				hangtam.setMaloaihang(mahangtam);
				foodItem.setLoaiHang(hangtam);
				//foodItem.setDmin(selectAdmin);
				try {
					HangHoaRepo.save(foodItem);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Thêm thành công");
				
				
			} else {
				JOptionPane.showMessageDialog(null, "Thêm thất bại");
			}
			
		}
	});
	CancelBut.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			tenmonTF.setText("");
			soluongTF.setText("");
			giaTF.setText("");
			
			
		}
	});
	btnNewButton_2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser jfilechoooser = new JFileChooser();
			jfilechoooser.setMultiSelectionEnabled(false);
			if (jfilechoooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				filepic = jfilechoooser.getSelectedFile();
			}
//			byte[] bytes = Files.readAllBytes(Paths.get(filepic));
//			ImageIcon icon = new ImageIcon(bytes);
//			System.out.println(""+filepic);
//			Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			JLabel pic= new JLabel("");
			//pic.setIcon(new ImageIcon(img));
			picpanel.add(pic);
			pic.setIcon(null);
			
		}
	});
}	
	private ComboBoxModel DefaultComboBoxModel(String[] strings) {
		// TODO Auto-generated method stub
		return null;
	}

	private void loadtable() {
		hangHoaRepository HangHoaRepository = new hangHoaRepository();
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Tên sản phẩm");
		defaultTableModel.addColumn("Giá sản phẩm");
		defaultTableModel.addColumn("Số lượng");
		defaultTableModel.addColumn("Loại sản phẩm");
		//defaultTableModel.addColumn("Tên quản lí");
		//defaultTableModel.addColumn("Ảnh sản phẩm");
		try {
			for (hangHoa HangHoa : HangHoaRepository.getAll()) {
				if(HangHoa.getSoLuong()>0) {
					defaultTableModel
					.addRow(HangHoa.toRowTable());
			table.setModel(defaultTableModel);
			table.getTableHeader().setReorderingAllowed(false);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(defaultTableModel);
		table.getTableHeader().setReorderingAllowed(false);
		//table.getColumnModel().getColumn(6).setCellRenderer(new ImageRender());
		//table.setRowHeight(50);
	}
	private void loadTableLoai() {
//		loaihangrepository loaihangre= new loaiHangHoaRepository();
//		defaultTableModel = new DefaultTableModel();
//		defaultTableModel.addColumn("Loại Sản Phẩm");
//		try {
//			for (loaiHang loaihang : loaiHangHoaRepository.get()) {
//				
//			table.setModel(defaultTableModel);
//			table.getTableHeader().setReorderingAllowed(false);
//				}
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		table.setModel(defaultTableModel);
//		table.getTableHeader().setReorderingAllowed(false);
	}
	private void loadtable_ban() {
		tableRepository tableRep = new tableRepository();
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Tên Bàn");
		defaultTableModel.addColumn("Trạng Thái");
		try {
			for (model.table bantam : tableRep.getAll()) {
					defaultTableModel
					.addRow(bantam.toRowTable());
					table_ban.setModel(defaultTableModel);
					table_ban.getTableHeader().setReorderingAllowed(false);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table_ban.setModel(defaultTableModel);
		table_ban.getTableHeader().setReorderingAllowed(false);
	}
	private class ImageRender extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int colum) {
			JLabel jlable = new JLabel();
			byte[] bytes = (byte[]) value;
			ImageIcon imageIcon = new ImageIcon(
					new ImageIcon(bytes).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			jlable.setIcon(imageIcon);
			return jlable;
		}
	}
	String resourcesPath = getClass().getResource("/images/").getPath();
	JFrame previousView;
	public File filepic;
}
