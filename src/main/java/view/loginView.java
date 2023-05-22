package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import model.Admin;
import model.PhienLamViec;
import model.nhanVienModel;
import repository.AdminReposity;
import repository.NhanVienReposity;
import repository.PhienLamViecRepository;
import utils.MaHoa;
import utils.NhanVienStatus;
import utils.TableStatus;
import view.admin.registerAdmin;
import view.admin.trangChuAdmin;
import view.nhanVien.TaoDonHang;
import view.nhanVien.TrangChuNV;
import view.nhanVien.trangChuNhanVien;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class loginView extends JFrame {
	private JTextField username_jtfiel;
	private JPasswordField password_pwfiel;
	private JComboBox vaitro_combobox;
	public loginView() {
		getContentPane().setBackground(new Color(236, 255, 255));
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
        panel_1.setBackground(new Color(236, 255, 255));
        panel_1.setBounds(337, 0, 347, 321);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(117, 24, 123, 34);
        panel_1.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Tài khoản :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(44, 133, 96, 29);
        panel_1.add(lblNewLabel_1);
        
        username_jtfiel = new JTextField();
        username_jtfiel.setBounds(140, 133, 160, 29);
        panel_1.add(username_jtfiel);
        username_jtfiel.setColumns(10);
        
        vaitro_combobox = new JComboBox();
        vaitro_combobox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Nhân Viên"}));
        vaitro_combobox.setBounds(140, 90, 84, 29);
        panel_1.add(vaitro_combobox);
        
        JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu :");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(44, 173, 96, 29);
        panel_1.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Vai trò :");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_2.setBounds(44, 93, 96, 29);
        panel_1.add(lblNewLabel_1_2);
        
        password_pwfiel = new JPasswordField();
        password_pwfiel.setBounds(140, 173, 160, 29);
        panel_1.add(password_pwfiel);
        
        JButton btnNewButton_1 = new JButton("Đăng nhập");
        btnNewButton_1.setBorder(UIManager.getBorder("Button.border"));
        btnNewButton_1.setBounds(44, 243, 96, 34);
        panel_1.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(vaitro_combobox.getSelectedItem().toString().equals("Admin")) {
            		
            		Admin adminModel= new Admin();
            		AdminReposity adminRepository = new AdminReposity();
        			String taikhoan =username_jtfiel.getText();
        			String matkhau = new String(password_pwfiel.getPassword());
        			matkhau= MaHoa.toSHA1(matkhau);
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
        			String taikhoan =username_jtfiel.getText();
        			String matkhau = new String(password_pwfiel.getPassword());
        			matkhau =MaHoa.toSHA1(matkhau);
        			nhanVienModel.setTaikhoan(taikhoan);
        			nhanVienModel.setMatkhau(matkhau);
        			nhanVienModel=nhanVienRepository.seclectByTenDangNhapVaMatKhau(nhanVienModel);
        	
        			if(nhanVienModel!=null) {
						PhienLamViecRepository phienlamviecRepository = new PhienLamViecRepository();
						PhienLamViec session= new PhienLamViec();
						session.setMaNhanVien(nhanVienModel.getManv());
						session.setTrangThai(NhanVienStatus.SERVING);
						try {
							phienlamviecRepository.save(session);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        				JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
        				dispose();	
        				TaoDonHang view = new TaoDonHang();
        				view.setVisible(true);
        			}
        			else {
        				JOptionPane.showMessageDialog(null, "Đăng nhập thất bại !");
        				xoaForm();
        			}
            	}
        	}
        });
//        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hung\\Downloads\\Login_icon-icons.com_52028.png"));
        
        JButton btnNewButton = new JButton("Đăng ký");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
         		registerAdmin register = new registerAdmin();
         		register.setVisible(true);
        	}
        });
        btnNewButton.setBounds(169, 243, 96, 34);
        panel_1.add(btnNewButton);

        btnNewButton.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\register_login_signup_icon_219991.png"));

//        btnNewButton.setIcon(new ImageIcon("C:\\Users\\hung\\Downloads\\register_login_signup_icon_219991.png"));

        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\logo.png"));
        lblNewLabel_2.setBounds(-15, 11, 361, 265);
        getContentPane().add(lblNewLabel_2);
        
        
        
        
        
		
	}

	private void xoaForm() {
		username_jtfiel.setText("");
		password_pwfiel.setText("");
		
	}
}
