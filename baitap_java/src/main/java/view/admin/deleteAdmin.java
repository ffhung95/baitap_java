package view.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.nhanVienModel;
import repository.NhanVienReposity;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class deleteAdmin extends JFrame {
	private JTable table;
	private JTextField tennv_textField;

	public deleteAdmin() {
		this.init();
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("TDELETE");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 301, 443);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Tên nhân viên"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(321, 10, 355, 443);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên nhân viên");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(20, 51, 134, 42);
		panel.add(lblNewLabel);
		
		tennv_textField = new JTextField();
		tennv_textField.setBounds(20, 103, 325, 42);
		panel.add(tennv_textField);
		tennv_textField.setColumns(10);
		
		JButton hienthi_jbutton = new JButton("Hiển thị thông tin");
		hienthi_jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiThongTinNhanVien();
			}
		});
		hienthi_jbutton.setBounds(10, 187, 118, 32);
		panel.add(hienthi_jbutton);
		
		JButton xoa_JButton = new JButton("Xóa");
		xoa_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hoten=tennv_textField.getText();
				nhanVienModel nhanvien= new nhanVienModel();
				nhanvien.setHoten(hoten);
				NhanVienReposity nvR = new NhanVienReposity();
				nvR.delete(nhanvien);
			}
		});
		xoa_JButton.setBounds(137, 187, 102, 32);
		panel.add(xoa_JButton);
		
		JButton xoa_JButton_1 = new JButton("Quay lại");
		xoa_JButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				quanLiNhanVien quanli = new quanLiNhanVien();
				quanli.setVisible(true);
			}
		});
		xoa_JButton_1.setBounds(243, 187, 102, 32);
		panel.add(xoa_JButton_1);
		loadtabel();
	}
	public void hienThiThongTinNhanVien() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String hotennv = model_table.getValueAt(i_row, 1) + "";
		tennv_textField.setText(hotennv);
	}
	private void loadtabel() {
		NhanVienReposity nhanVienReposity= new NhanVienReposity();
		DefaultTableModel defaultTableModel= new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Họ tên");
		for (nhanVienModel nhanvien : nhanVienReposity.getAdmin()) {
			defaultTableModel.addRow(new Object[] {
					nhanvien.getManv(),
					nhanvien.getHoten(),
								});
			table.setModel(defaultTableModel);
			table.getTableHeader().setReorderingAllowed(false);	
		}
	}
}
