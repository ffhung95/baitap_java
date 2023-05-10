package view.admin;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.hangHoaController;
import controller.loaiHangController;
import model.hangHoa;
import model.loaiHang;
import view.trangChu.hangHoaView;
import view.trangChu.loaiHangView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
public class HangHoaAdminView extends JFrame {

	private loaiHangController loaiHangCon;
	private hangHoaController hangHoaCon;
	private loaiHangView view;
	private hangHoaView hangHoaVi;
	private loaiHang loaihang;
	private hangHoa hanghoa;
	private JTextField textField;
	private JTable table;
public HangHoaAdminView() {
	
//	
//	this.loaiHangCon = new loaiHangController();
//	this.view = new loaiHangView();
//	this.hangHoaCon = new hangHoaController();
//	this.hangHoaVi = new hangHoaView();
//	this.hanghoa = new hangHoa();
//	this.loaihang = new loaiHang();
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
	
	textField = new JTextField();
	textField.setBounds(387, 24, 172, 19);
	panel.add(textField);
	textField.setColumns(10);
	
	JLabel lblNewLabel = new JLabel("Tìm kiếm");
	lblNewLabel.setBounds(304, 27, 45, 13);
	panel.add(lblNewLabel);
	
	JButton btnNewButton = new JButton("tìm kiếm");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnNewButton.setBounds(569, 23, 68, 21);
	panel.add(btnNewButton);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(301, 66, 365, 329);
	panel.add(separator);
	
	table = new JTable();
	table.setBounds(304, 66, 362, 322);
	panel.add(table);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(10, 10, 154, 443);
	panel.add(panel_1);
	panel_1.setLayout(null);
	
	JButton btnThmLoiHng = new JButton("Thêm loại hàng");
	btnThmLoiHng.setBounds(0, 190, 134, 37);
	panel_1.add(btnThmLoiHng);
	
	JButton btnThmSnPhm = new JButton("Thêm sản phẩm");
	btnThmSnPhm.setBounds(0, 237, 134, 37);
	panel_1.add(btnThmSnPhm);
	
	JButton btnngXut = new JButton("Thoát");
	btnngXut.setBounds(10, 379, 134, 37);
	panel_1.add(btnngXut);
	
//	JButton btnNewButton = new JButton("Thêm Loại Hàng");
//	btnNewButton.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			loaiHangCon.add(view);
//		} 
//	});
//	btnNewButton.setBounds(10, 136, 150, 39);
//	panel.add(btnNewButton);
//	
//	JButton btnHangHoa = new JButton("Thêm hàng hóa");
//	btnHangHoa.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			
//			hangHoaCon.add(hangHoaVi);
//		}
//	});
//	btnHangHoa.setBounds(10, 0, 150, 39);
//	panel.add(btnHangHoa);
//	JButton btnCapNhatHangHoa = new JButton("Cập nhật hàng hóa");
//	btnCapNhatHangHoa.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			hangHoaCon.edit(hangHoaVi, hanghoa);
//		}
//	});
//	btnCapNhatHangHoa.setBounds(10, 48, 150, 39);
//	panel.add(btnCapNhatHangHoa);
	
}
}
