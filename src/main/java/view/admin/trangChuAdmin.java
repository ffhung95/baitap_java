package view.admin;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import view.loginView;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class trangChuAdmin extends JFrame {
	private JPanel panel_1;
	int width=158;
	int height= 360;
	private JPanel contentPane;
	public trangChuAdmin() {
		contentPane = new JPanel();
		panel_1 = new JPanel();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.initComponents();
        this.setVisible(true);
	}

	private void initComponents() {
		setTitle("ADMIN");
    	this.setSize(700, 401);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setResizable(false);
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 10, 686, 354);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 3, 0, 0));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 1, 360);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeMenuBar();
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hung\\Downloads\\cancel_close_delete_exit_logout_remove_x_icon_123217.png"));
		lblNewLabel.setBounds(116, 10, 32, 23);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hung\\Downloads\\student_work_office_desk_work_space_computer_working_support_icon_191191.png"));
		lblNewLabel_1.setBounds(20, 10, 96, 78);
		panel_1.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new MatteBorder(4, 1, 1, 1, (Color) new Color(0, 0, 0)));
		separator.setBounds(0, 98, 158, 2);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(new MatteBorder(3, 1, 1, 1, (Color) new Color(0, 0, 0)));
		separator_1.setBounds(0, 282, 158, 2);
		panel_1.add(separator_1);
		
		JButton btnNewButton = new JButton("Quản lí nhân viên");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				quanLiNhanVien quanlinv = new quanLiNhanVien();
				quanlinv.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(0, 112, 158, 55);
		panel_1.add(btnNewButton);
		
		JButton btnHngHa = new JButton("Hàng hóa");
		btnHngHa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHngHa.setBounds(0, 164, 158, 55);
		panel_1.add(btnHngHa);
		
		JButton btnThngK = new JButton("Thống kê");
		btnThngK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThngK.setBounds(0, 217, 158, 55);
		panel_1.add(btnThngK);
		
		JButton btnngXut = new JButton("Đăng xuất");
		btnngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginView login = new loginView();
				login.setVisible(true);
			}
		});
		btnngXut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnngXut.setBounds(0, 294, 158, 55);
		panel_1.add(btnngXut);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openMenuBar();			}

			
		});
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\hung\\Downloads\\bar-menu_icon-icons.com_70305.png"));
		lblNewLabel_3.setBounds(10, 10, 40, 26);
		panel.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 240, 240));
		panel_2.setBounds(0, 43, 686, 270);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\hung\\Downloads\\nhuong-quyen-highland-coffee.png"));
		lblNewLabel_6.setBounds(0, 5, 686, 303);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("Highlands Coffee");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(273, 11, 161, 36);
		panel.add(lblNewLabel_4);
		
	}
	private void openMenuBar() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for( int i=0;i<width;i++) {
					panel_1 .setSize(width,height);
				}
				
			}
		}).start();
		
	}
	private void closeMenuBar() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for( int i=width;i>0;i--) {
					panel_1 .setSize(i,height);
				}
				
			}
		}).start();
	}
}
