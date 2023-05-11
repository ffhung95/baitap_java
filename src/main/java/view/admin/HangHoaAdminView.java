package view.admin;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.hangHoaController;
import controller.loaiHangController;
import model.hangHoa;
import model.loaiHang;
import repository.hangHoaRepository;
import view.trangChu.hangHoaView;
import view.trangChu.loaiHangView;
import view.trangChu.themDonHangView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class HangHoaAdminView extends JFrame {

	private loaiHangController loaiHangCon;
	private hangHoaController hangHoaCon;
	private loaiHangView loaiHangview;
	private hangHoaView hangHoaVi;
	private loaiHang loaihang;
	private hangHoa hanghoa;
	private JTextField textField_timkiem; 
	private DefaultTableModel defaultTableModel;
	private JTable table;
public HangHoaAdminView() {
	
	
	this.loaiHangCon = new loaiHangController();
	this.loaiHangview = new loaiHangView();
	this.hangHoaCon = new hangHoaController();
	this.hangHoaVi = new hangHoaView();
	this.hanghoa = new hangHoa();
	this.loaihang = new loaiHang();
	defaultTableModel = new DefaultTableModel();
	this.init();
	this.setVisible(true);
}

private void init() {
	this.setTitle("Hàng Hóa");
	this.setSize(700, 500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	getContentPane().setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBounds(0, 0, 676, 453);
	getContentPane().add(panel);
	panel.setLayout(null);
	
	textField_timkiem = new JTextField();
	textField_timkiem.setBounds(447, 14, 219, 27);
	panel.add(textField_timkiem);
	textField_timkiem.setColumns(10);
	
	JLabel lblNewLabel = new JLabel("Tìm kiếm");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel.setBounds(348, 11, 89, 30);
	panel.add(lblNewLabel);
	
	JButton btnNewButton = new JButton("tìm kiếm");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String tensanpham= textField_timkiem.getText();
			hangHoaRepository HangHoaRepository = new hangHoaRepository();
			hangHoa HangHoa = new hangHoa();
			HangHoa.setTenHangHoa(tensanpham);
			try {
				if(HangHoaRepository.searchByName(tensanpham)!=null) {
					List<hangHoa>list =HangHoaRepository.searchByName(tensanpham);
					defaultTableModel.setRowCount(0);
					for (hangHoa hh : list) {
						defaultTableModel.addRow(new Object[]{
								hh.getMaHangHoa(),hh.getTenHangHoa(),hh.getGiaHangHoa(),
								hh.getSoLuong(),hh.getMaLoaiHang(),hh.getAnhHangHoa()
	                    });
						defaultTableModel.fireTableDataChanged();
	                }
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	btnNewButton.setBounds(446, 50, 94, 21);
	panel.add(btnNewButton);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(10, 10, 185, 443);
	panel.add(panel_1);
	panel_1.setLayout(null);
	
	JButton btnThmLoiHng = new JButton("Thêm loại sản phẩm");
	btnThmLoiHng.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			loaiHangCon.add(loaiHangview);
			
		}
	});
	btnThmLoiHng.setBounds(0, 172, 185, 78);
	panel_1.add(btnThmLoiHng);
	
	JButton btnngXut = new JButton("Thoát");
	btnngXut.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			trangChuAdmin trangchuview =new trangChuAdmin();
			trangchuview.setVisible(true);
		}
	});
	btnngXut.setBounds(0, 356, 185, 77);
	panel_1.add(btnngXut);
	
	JButton btnThmSnPhm = new JButton("Sản phẩm");
	btnThmSnPhm.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			hangHoaCon.add(hangHoaVi);
		}
	});
	btnThmSnPhm.setBounds(0, 251, 185, 78);
	panel_1.add(btnThmSnPhm);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setBorder(new MatteBorder(3, 1, 1, 1, (Color) new Color(0, 0, 0)));
	separator_1.setBounds(0, 339, 185, 2);
	panel_1.add(separator_1);
	
	JSeparator separator_1_1 = new JSeparator();
	separator_1_1.setBorder(new MatteBorder(3, 1, 1, 1, (Color) new Color(0, 0, 0)));
	separator_1_1.setBounds(0, 160, 185, 2);
	panel_1.add(separator_1_1);
	
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\download.jfif"));
	lblNewLabel_1.setBounds(0, 10, 175, 147);
	panel_1.add(lblNewLabel_1);
	
	JButton btnHy = new JButton("Hủy");
	btnHy.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textField_timkiem.setText("");
		}
	});
	btnHy.setBounds(572, 51, 94, 21);
	panel.add(btnHy);
	
	JLabel lblNewLabel_2 = new JLabel("Thông tin sản phẩm");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_2.setBounds(373, 95, 144, 27);
	panel.add(lblNewLabel_2);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(205, 120, 447, 304);
	panel.add(scrollPane);
	
	table = new JTable();
	scrollPane.setViewportView(table);
	loadtable();
}
private void loadtable() {
	hangHoaRepository HangHoaRepository = new hangHoaRepository();
	 defaultTableModel = new DefaultTableModel();
	defaultTableModel.addColumn("ID");
	defaultTableModel.addColumn("Tên sản phẩm");
	defaultTableModel.addColumn("Giá sản phẩm");
	defaultTableModel.addColumn("Số lượng");
	defaultTableModel.addColumn("Loại sản phẩm");
	defaultTableModel.addColumn("Ảnh sản phẩm");
	try {
		for (hangHoa HangHoa : HangHoaRepository.getAll()) {
			defaultTableModel.addRow(new Object[] { 
					HangHoa.getMaHangHoa(),HangHoa.getTenHangHoa(),HangHoa.getGiaHangHoa(),
					HangHoa.getSoLuong(),HangHoa.getMaLoaiHang(),HangHoa.getAnhHangHoa()});
			table.setModel(defaultTableModel);
			table.getTableHeader().setReorderingAllowed(false);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
