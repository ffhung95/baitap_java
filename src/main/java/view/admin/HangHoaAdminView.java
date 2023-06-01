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
import view.trangChu.hangHoaView;
import view.trangChu.loaiHangView;
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
	public HangHoaAdminView() {
		this.init();
		this.setVisible(true);
		
	}

	private void init() {
		this.setSize(1062, 703);
		panel = new JPanel();
		panel.setBackground(new Color(225, 255, 255));
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
		Tab.setBackground(new Color(225, 255, 255));
			Tab.setBounds(28, 160, 1062, 543);
			Tab.setLayout(null);
			panel.add(Tab);
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(-53, 0, 656, 543);
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
	LoaiHangTbl.setBorder(null);
	LoaiHangTbl.setBackground(new Color(225, 255, 255));
	LoaiHangTbl.setBounds(0, 0, 378, 543);
	LoaiHangTblAll.add(LoaiHangTbl);
	Tab.add(LoaiHangTblAll);
	LoaiHangTbl.setLayout(null);
	
	JLabel tenmonlbl = new JLabel("Tên Món :");
	tenmonlbl.setHorizontalAlignment(SwingConstants.LEFT);
	tenmonlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
	tenmonlbl.setBounds(40, 30, 88, 30);
	LoaiHangTbl.add(tenmonlbl);
	
	JLabel gialbl = new JLabel("Giá :");
	gialbl.setHorizontalAlignment(SwingConstants.LEFT);
	gialbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
	gialbl.setBounds(40, 80, 88, 30);
	LoaiHangTbl.add(gialbl);
	
	JLabel soluonglbl = new JLabel("Số Lượng :");
	soluonglbl.setHorizontalAlignment(SwingConstants.LEFT);
	soluonglbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
	soluonglbl.setBounds(40, 130, 88, 30);
	LoaiHangTbl.add(soluonglbl);
	
	JLabel hinhanhlbl = new JLabel("Hình Ảnh :");
	hinhanhlbl.setHorizontalAlignment(SwingConstants.LEFT);
	hinhanhlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
	hinhanhlbl.setBounds(40, 230, 88, 30);
	LoaiHangTbl.add(hinhanhlbl);
	
	JLabel loailbl = new JLabel("Loại :");
	loailbl.setHorizontalAlignment(SwingConstants.LEFT);
	loailbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
	loailbl.setBounds(40, 180, 88, 30);
	LoaiHangTbl.add(loailbl);
	
	tenmonTF = new JTextField();
	tenmonTF.setFont(new Font("Tahoma", Font.PLAIN, 12));
	tenmonTF.setBounds(125, 30, 170, 30);
	LoaiHangTbl.add(tenmonTF);
	tenmonTF.setColumns(10);
	
	giaTF = new JTextField();
	giaTF.setFont(new Font("Tahoma", Font.PLAIN, 12));
	giaTF.setColumns(10);
	giaTF.setBounds(125, 80, 170, 30);
	LoaiHangTbl.add(giaTF);
	
	soluongTF = new JTextField();
	soluongTF.setFont(new Font("Tahoma", Font.PLAIN, 12));
	soluongTF.setColumns(10);
	soluongTF.setBounds(125, 130, 170, 30);
	LoaiHangTbl.add(soluongTF);
	
	JLabel lblNewLabel_2 = new JLabel("vnđ");
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
	lblNewLabel_2.setBounds(305, 80, 26, 30);
	LoaiHangTbl.add(lblNewLabel_2);
	
	JButton btnNewButton_2 = new JButton("Chọn");
	btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnNewButton_2.setBounds(125, 230, 85, 30);
	LoaiHangTbl.add(btnNewButton_2);
	
	picpanel = new JPanel();
	picpanel.setBackground(new Color(225, 255, 255));
	picpanel.setBounds(40, 290, 151, 151);
	LoaiHangTbl.add(picpanel);
	
	JComboBox loaiCB = new JComboBox();
	loaiCB.setFont(new Font("Tahoma", Font.PLAIN, 12));
	loaiCB.setModel(new DefaultComboBoxModel(new String[] {"Trà", "Trà Sữa", "Cafe", "Sinh Tố", "Trái Cây", "Nước Ép"}));
	//loaiCB.setModel(DefaultComboBoxModel(new String[] {"Trà", "Trà sữa", "Nước ép", "Sinh Tố", "Cafe"}));
	loaiCB.setBounds(125, 180, 170, 30);
	LoaiHangTbl.add(loaiCB);
	
	try {
		for (loaiHang loaihang : LoaiHangRepo.getAll()) {
			//loaiCB.setModel(new DefaultComboBoxModel<>());
		}
		for(Admin ADMIN :adminrepository.getAdmin()) {
			//getAdminComboBoxModel().addElement(ADMIN);
		}
	} catch (Exception e) {
	}
	
	JButton ConfirmBut = new JButton("Xác Nhận");
	ConfirmBut.setFont(new Font("Tahoma", Font.PLAIN, 14));
	ConfirmBut.setBounds(40, 474, 119, 40);
	ImageIcon iconConfirm = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\done.png");
	ConfirmBut.setIcon(iconConfirm);
	LoaiHangTbl.add(ConfirmBut);
	
	JButton CancelBut = new JButton("Hủy Bỏ");
	CancelBut.setFont(new Font("Tahoma", Font.PLAIN, 14));
	CancelBut.setBounds(176, 474, 119, 40);
	ImageIcon iconCancel = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\delete.png");
	CancelBut.setIcon(iconCancel);
	LoaiHangTbl.add(CancelBut);
	
	JLabel lblNewLabel = new JLabel("Danh Sách Món");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblNewLabel.setBackground(new Color(240, 240, 240));
	lblNewLabel.setBounds(606, 51, 113, 27);
	panel.add(lblNewLabel);
	
	JButton btnNewButton_1 = new JButton("<");
	btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnNewButton_1.setBounds(564, 49, 41, 30);
	panel.add(btnNewButton_1);
	
	JButton btnNewButton_1_1 = new JButton(">");
	btnNewButton_1_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnNewButton_1_1.setBounds(719, 51, 41, 30);
	panel.add(btnNewButton_1_1);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(28, 14, 197, 136);
	panel.add(panel_1);
	
	
	////////////////////////////////////////////////
	ConfirmBut.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			hangHoa foodItem = new hangHoa();
			hangHoaRepository HangHoaRepo = new hangHoaRepository();
			int soluong = Integer.valueOf(soluongTF.getText());
			loaiHang selectCategory = (loaiHang) loaiCB.getSelectedItem();
			//Admin selectAdmin = (Admin) view.getComboBox_tenquanli().getSelectedItem();
			String name = tenmonTF.getText(), unitPrice = giaTF.getText();
			if (name.isEmpty() || unitPrice.isEmpty() || selectCategory == null) {
				//throw new Exception("Vui lÃƒÂ²ng Ã„â€˜iÃ¡Â»Ân Ã„â€˜Ã¡ÂºÂ§y Ã„â€˜Ã¡Â»Â§ thÃƒÂ´ng tin");
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
				foodItem.setLoaiHang(selectCategory);
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
