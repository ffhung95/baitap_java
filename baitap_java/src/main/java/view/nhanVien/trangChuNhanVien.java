package view.nhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class trangChuNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	public trangChuNhanVien() {
		this.initComponents();
        this.setVisible(true);
	}

	private void initComponents() {
		setTitle("Nhân Viên");
    	this.setSize(700, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setResizable(false);
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 666, 159);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Tên nhân viên");
        lblNewLabel.setBounds(10, 10, 86, 22);
        panel.add(lblNewLabel);
        
        JLabel lblTiKhon = new JLabel("Tài khoản");
        lblTiKhon.setBounds(10, 43, 86, 22);
        panel.add(lblTiKhon);
        
        JLabel lblMtKhu = new JLabel("Mật khẩu");
        lblMtKhu.setBounds(10, 75, 86, 22);
        panel.add(lblMtKhu);
        
        JLabel lblSdt = new JLabel("SDT");
        lblSdt.setBounds(383, 10, 36, 22);
        panel.add(lblSdt);
        
        JLabel lblNgyVoLm = new JLabel("Ngày vào làm");
        lblNgyVoLm.setBounds(383, 43, 86, 22);
        panel.add(lblNgyVoLm);
        
        JLabel lblChcV = new JLabel("Chức Vụ");
        lblChcV.setBounds(383, 75, 55, 22);
        panel.add(lblChcV);
        
        JLabel lblLng = new JLabel("Lương");
        lblLng.setBounds(383, 107, 55, 22);
        panel.add(lblLng);
        
        textField = new JTextField();
        textField.setBounds(106, 12, 159, 19);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(106, 45, 159, 19);
        panel.add(textField_1);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(106, 77, 159, 19);
        panel.add(passwordField);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(481, 12, 159, 19);
        panel.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(481, 45, 159, 19);
        panel.add(textField_3);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Quản Lí", "Nhân Viên phục vụ"}));
        comboBox.setBounds(479, 76, 64, 21);
        panel.add(comboBox);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(481, 109, 159, 19);
        panel.add(textField_4);
        
        JButton btnNewButton = new JButton("Thêm");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(10, 109, 85, 21);
        panel.add(btnNewButton);
        
        JButton btnXa = new JButton("Xóa");
        btnXa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnXa.setBounds(106, 108, 85, 21);
        panel.add(btnXa);
        
        JButton btnSa = new JButton("Cập nhật");
        btnSa.setBounds(215, 108, 85, 21);
        panel.add(btnSa);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 184, 666, 129);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Id", "Tên nhân viên", "SDT", "Ngày vào làm", "Chức vụ", "Lương"
        	}
        ));
        table.setBounds(10, 116, 629, -105);
        panel_1.add(table);
		
	}
}
