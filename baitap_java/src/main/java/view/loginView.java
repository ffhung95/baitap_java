package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import model.admin;
import model.nhanVienModel;
import repository.AdminReposity;
import repository.NhanVienReposity;
import view.admin.registerAdmin;
import view.admin.trangChuAdmin;
import view.nhanVien.trangChuNhanVien;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class loginView extends JFrame {
	private JTextField username_jtfiel;
	private JPasswordField password_pwfiel;
	private JComboBox vaitro_combobox;
	public loginView() {
		this.initComponents();
        this.setVisible(true);
	}
	private void initComponents() {
	 	setTitle("Loading....");
    	this.setSize(700, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setResizable(false);
        getContentPane().setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 255, 255));
        panel_1.setBounds(337, 10, 339, 303);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Login Page");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(117, 24, 123, 34);
        panel_1.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(44, 135, 96, 27);
        panel_1.add(lblNewLabel_1);
        
        username_jtfiel = new JTextField();
        username_jtfiel.setBounds(140, 133, 160, 29);
        panel_1.add(username_jtfiel);
        username_jtfiel.setColumns(10);
        
        vaitro_combobox = new JComboBox();
        vaitro_combobox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Nhân Viên"}));
        vaitro_combobox.setBounds(140, 84, 84, 27);
        panel_1.add(vaitro_combobox);
        
        JLabel lblNewLabel_1_1 = new JLabel("Password");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(44, 172, 96, 34);
        panel_1.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Select  Role");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_2.setBounds(44, 84, 96, 34);
        panel_1.add(lblNewLabel_1_2);
        
        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	if(vaitro_combobox.getSelectedItem().toString().equals("Admin")) {
        		
        		admin adminModel= new admin();
        		AdminReposity adminRepository = new AdminReposity();
    			String taikhoan =username_jtfiel.getText();
    			String matkhau = new String(password_pwfiel.getPassword());
    			adminModel.setTaikhoan(taikhoan);
    			adminModel.setMatkhau(matkhau);
    			adminModel=adminRepository.seclectByTenDangNhapVaMatKhau(adminModel);
    			if(adminModel!=null) {
    				JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
    				dispose();	
    			
    				trangChuAdmin trangchu= new trangChuAdmin();
    				trangchu.setVisible(true);
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "Đăng nhập thất bại !");
    				xoaForm();
    			}
        	}
        	else {
        		nhanVienModel nhanVienModel= new nhanVienModel();
        		NhanVienReposity nhanVienRepository= new NhanVienReposity();
        		AdminReposity adminRepository = new AdminReposity();
    			String taikhoan =username_jtfiel.getText();
    			String matkhau = new String(password_pwfiel.getPassword());
    			nhanVienModel.setTaikhoan(taikhoan);
    			nhanVienModel.setMatkhau(matkhau);
    			nhanVienModel=nhanVienRepository.seclectByTenDangNhapVaMatKhau(nhanVienModel);
    			if(nhanVienModel!=null) {
    				JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
    				dispose();	
    				trangChuNhanVien trangchu= new trangChuNhanVien();
    				trangchu.setVisible(true);
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "Đăng nhập thất bại !");
    				xoaForm();
    			}
        	}
        		
        	}

			private void xoaForm() {
				username_jtfiel.setText("");
				password_pwfiel.setText("");
				
			}
        });
        btnNewButton.setBounds(44, 243, 96, 21);
        panel_1.add(btnNewButton);
        
        JButton btnRegister = new JButton("Register\r\n");
        btnRegister.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		registerAdmin register = new registerAdmin();
        		register.setVisible(true);
        	}
        });
        btnRegister.setBounds(204, 243, 96, 21);
        panel_1.add(btnRegister);
        
        password_pwfiel = new JPasswordField();
        password_pwfiel.setBounds(140, 179, 160, 27);
        panel_1.add(password_pwfiel);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 10, 325, 303);
        getContentPane().add(panel);
		
	}
}
