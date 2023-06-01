package view.admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Menu;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import view.loginView;
import view.nhanVien.TableEmployessWiew;
import view.trangChu.tableView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.tableController;
import model.HoaDon;
import model.table;
import repository.HoaDonRepository;
import repository.tableRepository;

import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class trangChuAdmin extends JFrame {
	private JPanel panel_1;
	private JPanel panel_thongke;
	// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	private JLabel ltime;
	private JLabel ltime2;
	int width = 276;
	int height = 714;
	private JPanel contentPane;
	private JPanel p_thongke;

	public trangChuAdmin() {
		contentPane = new JPanel();
		panel_1 = new JPanel();
		contentPane = new JPanel();
		setTime();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.initComponents();
		this.setVisible(true);
		ImageIcon mainIcon = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\coffeeAdmin.png");
		this.setIconImage(mainIcon.getImage());
	}

	private void initComponents() {
		setTitle("ADMIN");
		this.setSize(1360, 751);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		this.setResizable(false);
		getContentPane().setLayout(null);
		// setTime();
		JPanel panel = new JPanel();
		HangHoaAdminView hangHoaView = new HangHoaAdminView();
		quanLiNhanVien quanlinv = new quanLiNhanVien();

		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.setBackground(new Color(139, 236, 236));
		panel.setBounds(0, 0, 1362, 783);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();

		panel_thongke = new JPanel();

		panel_thongke.setBackground(new Color(139, 236, 236));
		panel_thongke.setBounds(274, 62, 1053, 650);
		panel.add(panel_thongke);
		panel_thongke.setLayout(null);
		

		panel_thongke.setBounds(264, 71, 1063, 642);
		panel.add(panel_thongke);
		panel_thongke.setLayout(null);

		p_thongke= new JPanel();
		p_thongke.setBounds(0, 0, 1063, 642);
		panel_thongke.add(p_thongke);
		p_thongke.setLayout(null);
		JPanel p_day= new JPanel();
		p_day.setBounds(523, 233, 510, 397);
		p_day.setLayout(null);
		table_ngay = new JTable();
		table_ngay.setBounds(0, 0, 506, 390);
		JScrollPane scrday= new JScrollPane(table_ngay);
		scrday.setBounds(10, 10, 490, 347);
		p_day.add(scrday);
		p_thongke.add(p_day);

		JPanel p_month= new JPanel();
		p_month.setBounds(10, 233, 510, 397);
		p_month.setLayout(null);
		
		
		table_thang = new JTable();
		table_thang.setBounds(0,  0,  517,  390);
		JScrollPane src_month= new JScrollPane(table_thang);
		src_month.setBounds(10, 10, 490, 342);
		p_month.add(src_month);
		//table_thang.setBounds(536, 199, 517, 402);
		p_thongke.add(p_month);
		
		JLabel lblNewLabel = new JLabel("Bảng doanh thu theo tháng");
		lblNewLabel.setBounds(169, 206, 198, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		p_thongke.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Bảng doanh thu theo ngày");
		lblNewLabel_2.setBounds(680, 206, 191, 17);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		p_thongke.add(lblNewLabel_2);
		HoaDonRepository hoadonRe= new HoaDonRepository();
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(104, 10, 222, 163);
		panel_3.setBackground(new Color(128, 255, 255));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		p_thongke.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Doanh Thu Hôm Nay");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_4.setBounds(0, 0, 226, 40);
		panel_3.add(lblNewLabel_4);
		
		JLabel doanhthu_label = new JLabel("");
		doanhthu_label.setBackground(new Color(255, 0, 0));
		doanhthu_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		doanhthu_label.setHorizontalAlignment(SwingConstants.CENTER);
		doanhthu_label.setBounds(0, 86, 226, 39);
		panel_3.add(doanhthu_label);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		try {
			for(HoaDon hoadon :hoadonRe.getDanhThuhomnay()) {
				lblNewLabel_4_1.setText(""+hoadon.getNgay());
				float tongtienhomnay=hoadon.getTongTien();
				doanhthu_label.setText(tongtienhomnay+"");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_4_1.setBounds(0, 44, 226, 40);
		panel_3.add(lblNewLabel_4_1);

//		panel_1.setBorder(new EmptyBorder(5, 3, 0, 0));
//		panel_1.setBackground(Color.BLUE);
//		panel_1.setBounds(0, 0, 168, 714);

		Border borderShadow = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		// panel_1.setBorder(borderShadow);
//		panel_1.setBorder(new EmptyBorder(5, 3, 0, 0));
		panel_1.setBackground(new Color(139, 236, 236));
		panel_1.setBounds(0, 0, 264, 710);

		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\btl\\baitap_java\\src\\main\\resources\\images\\student_work_office_desk_work_space_computer_working_support_icon_191191.png"));

		lblNewLabel_1.setBounds(10, 10, 106, 78);

		lblNewLabel_1.setBounds(10, 10, 225, 78);

		panel_1.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBorder(new MatteBorder(4, 1, 1, 1, (Color) new Color(0, 0, 0)));
		separator.setBounds(0, 98, 266, 2);
		panel_1.add(separator);

		JButton btnNewButton = new JButton("Quản lí nhân viên");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_thongke.removeAll();
				panel_thongke.repaint();

				panel_thongke.add(quanlinv);
				panel_thongke.repaint();
				// quanlinv.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\user-group.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(5, 140, 254, 71);
		panel_1.add(btnNewButton);

		JButton btnHngHa = new JButton("Hàng hóa");
		btnHngHa.setBackground(new Color(255, 255, 255));
		btnHngHa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_thongke.removeAll();
				panel_thongke.repaint();
				panel_thongke.add(hangHoaView);
				// panel_thongke.repaint();
				// hangHoaView.setVisible(true);
			}
		});
		btnHngHa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHngHa.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\cart.png"));
		btnHngHa.setBounds(5, 220, 254, 71);
		panel_1.add(btnHngHa);

		JButton btnThngK = new JButton("Thống kê");
		btnThngK.setBackground(new Color(255, 255, 255));
		btnThngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_thongke.removeAll();
				panel_thongke.repaint();
				panel_thongke.add(p_thongke);
			}
		});
		btnThngK.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\futures.png"));
		btnThngK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThngK.setBounds(5, 298, 254, 71);
		panel_1.add(btnThngK);

		JButton btnngXut = new JButton("Đăng xuất");
		btnngXut.setBackground(new Color(255, 255, 255));
		btnngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginView login = new loginView();
				login.setVisible(true);
			}
		});
		btnngXut.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\logout.png"));
		btnngXut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnngXut.setBounds(5, 602, 254, 71);
		panel_1.add(btnngXut);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(225, 255, 255));
		panel_2.setBounds(264, 10, 1063, 41);
		panel.add(panel_2);
		panel_2.setLayout(null);

		ltime = new JLabel("");
		ltime.setBackground(new Color(255, 255, 128));
		ltime.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
		ltime.setHorizontalAlignment(SwingConstants.CENTER);
		ltime.setBounds(221, 0, 211, 41);
		panel_2.add(ltime);

		ltime2 = new JLabel("");
		ltime2.setBackground(new Color(255, 255, 128));
		ltime2.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
		ltime2.setHorizontalAlignment(SwingConstants.CENTER);
		ltime2.setBounds(0, 0, 211, 41);
		panel_2.add(ltime2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(928, 0, 171, 58);
		panel_2.add(lblNewLabel_3);

//		JLabel lblNewLabel_6 = new JLabel("");
//		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\hung\\Downloads\\nhuong-quyen-highland-coffee.png"));
//		lblNewLabel_6.setBounds(0, 5, 686, 303);
//		panel_2.add(lblNewLabel_6);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(
				new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\nhuong-quyen-highland-coffee.png"));
		lblNewLabel_6.setBounds(0, 5, 686, 303);

		Table_Panel_All = new JPanel();
		Table_Panel_All.setBounds(0, 0, 1062, 645);
		Table_Panel_All.setLayout(null);

		JPanel ptableview = new JPanel();
		ptableview.setBounds(0, 45, 1030, 600);
		ptableview.setLayout(null);
		tableView = new JTable();
		tableView.setSize(1000, 500);
		tableView.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Tên bàn", "Trạng Thái" }));
		JScrollPane scrtable = new JScrollPane(tableView);

		scrtable = new JScrollPane(tableView);
		ptableview.add(scrtable);
		scrtable.setBounds(0, 0, 1000, 500);
		ptableview.add(scrtable);
		Table_Panel_All.add(ptableview);
		Table_Panel_All.add(ptableview);
		tabledoanhthungay();
		tabledoanhthuthang();
		// panel_thongke.add(Table_Panel_All);
	}
	
	private void tabledoanhthungay() {
		HoaDonRepository hoadonRe = new HoaDonRepository();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Ngày ");
		defaultTableModel.addColumn("Tổng tiền");
		table_thang.setModel(defaultTableModel);
		try {
			for(HoaDon doanhthu:hoadonRe.getDanhThu()) {
				defaultTableModel.addRow(new Object[] { doanhthu.getNgayInHoaDon(),doanhthu.getTongTien()});
				tableView.getTableHeader().setReorderingAllowed(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void tabledoanhthuthang() {
		HoaDonRepository hoadonRe = new HoaDonRepository();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Năm ");
		defaultTableModel.addColumn("Tháng ");
		defaultTableModel.addColumn("Tổng tiền");
		table_ngay.setModel(defaultTableModel);
		try {
			for(HoaDon doanhthu:hoadonRe.getDanhThuThang()) {
				defaultTableModel.addRow(new Object[] { doanhthu.getNam(),doanhthu.getThang(),doanhthu.getTongTien()});
				tableView.getTableHeader().setReorderingAllowed(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadTable() {
		tableRepository tableReposity = new tableRepository();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Tên bàn");
		defaultTableModel.addColumn("Trạng thái");
		tableView.setModel(defaultTableModel);
		try {
			for (table ban : tableReposity.getAll()) {
				defaultTableModel.addRow(new Object[] { ban.getMaBan(), ban.getName(), ban.getTrangthai(), });

				tableView.getTableHeader().setReorderingAllowed(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int getMaban() {
		DefaultTableModel model_table = (DefaultTableModel) tableView.getModel();
		int i_row = tableView.getSelectedRow();
		int maban = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		return maban;
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

	private tableController tablecontroller;
	private tableView view;
	private table tableModel;
	private JTable tableView;
	private tableRepository tablerepository;
	private JPanel Table_Panel_All;
	private JTable table_ngay;
	private JTable table_thang;
}
