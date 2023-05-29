package view.admin;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import view.loginView;
import view.nhanVien.TableEmployessWiew;
import view.trangChu.hangHoaView;
import view.trangChu.tableView;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
public class trangChuAdmin extends JFrame {
	private JPanel panel_1;
	private JPanel panel;
	int width=170;
	int height= 360;
	private JPanel contentPane;
	private CardLayout card;
	private JPanel panel_right;
	public trangChuAdmin() {
		contentPane = new JPanel();
		panel_1 = new JPanel();
		contentPane = new JPanel();
		card = new CardLayout();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setLayout(new BorderLayout());
		panel.add(panel_1, BorderLayout.WEST);
		panel.add(panel_right, BorderLayout.CENTER);
		
		quanLiNhanVien nhanvien = new quanLiNhanVien();
		hangHoaView hanghoa = new hangHoaView();
		tableView ban = new tableView();
		
		panel_right.setLayout(card);
		panel_right.add(nhanvien.panelNhanvien,"Trang 1");
		card.show(panel_right, "Trang 1");
		this.setSize(1290, 760);
        this.setLocationRelativeTo(null);
		this.initComponents();
//        this.setVisible(true);
	}

	private tableView tableView() {
		// TODO Auto-generated method stub
		return null;
	}

	private hangHoaView hangHoaView() {
		// TODO Auto-generated method stub
		return null;
	}

	private quanLiNhanVien quanLiNhanVien() {
		// TODO Auto-generated method stub
		return null;
	}

	private void initComponents() {
		setTitle("ADMIN");
    	this.setSize(1390, 760);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setResizable(false);
        getContentPane().setLayout(null);
        
        panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.setBackground(new Color(236, 255, 255));
		panel.setBounds(0, 0, 1376, 723);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();

		panel_1.setBorder(new EmptyBorder(5, 3, 0, 0));
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 1, 360);

		Border borderShadow = BorderFactory.createCompoundBorder(
                 BorderFactory.createLineBorder(Color.BLACK),
                 BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );
		panel_1.setBorder(borderShadow);
//		panel_1.setBorder(new EmptyBorder(5, 3, 0, 0));
		panel_1.setBackground(new Color(236, 255, 255));
		panel_1.setBounds(-1, -1, 170, 364);

		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeMenuBar();
			}
		});

		lblNewLabel.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\cancel_close_delete_exit_logout_remove_x_icon_123217.png"));
		lblNewLabel.setBounds(116, 10, 32, 23);

		lblNewLabel.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\delete.png"));
		lblNewLabel.setBounds(139, 11, 21, 23);

		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\student_work_office_desk_work_space_computer_working_support_icon_191191.png"));

		lblNewLabel_1.setBounds(20, 10, 96, 78);

		lblNewLabel_1.setBounds(10, 10, 96, 78);

		panel_1.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new MatteBorder(4, 1, 1, 1, (Color) new Color(0, 0, 0)));
		separator.setBounds(0, 99, 191, 1);
		panel_1.add(separator);
		
		JButton btnNewButton = new JButton("Quản lí nhân viên");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				quanLiNhanVien quanlinv = new quanLiNhanVien();
				quanlinv.setVisible(true);
			}
		});
		 
		btnNewButton.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\user-group.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 111, 151, 41);
		panel_1.add(btnNewButton);
		
		JButton btnHngHa = new JButton("Hàng hóa");
		btnHngHa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HangHoaAdminView hangHoaView = new HangHoaAdminView();
				hangHoaView.setVisible(true);
			}
		});
		btnHngHa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnHngHa.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\cart.png"));
		btnHngHa.setBounds(10, 163, 151, 41);
		panel_1.add(btnHngHa);
		
		JButton btnThngK = new JButton("Thống kê");
		btnThngK.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\futures.png"));
		btnThngK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThngK.setBounds(10, 261, 151, 41);
		panel_1.add(btnThngK);
		
		JButton btnngXut = new JButton("Đăng xuất");
		btnngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginView login = new loginView();
				login.setVisible(true);
			}
		});
		btnngXut.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\logout.png"));
		btnngXut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnngXut.setBounds(10, 312, 150, 41);
		panel_1.add(btnngXut);
		
		JButton btnQunLBn = new JButton("Quản lí bàn");
		btnQunLBn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TableEmployessWiew view = new TableEmployessWiew();
				view.setVisible(true);
			}
		});
		btnQunLBn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnQunLBn.setBounds(9, 214, 151, 41);
		panel_1.add(btnQunLBn);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openMenuBar();			}

			
		});

		lblNewLabel_3.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\bar-menu_icon-icons.com_70305.png"));
		lblNewLabel_3.setBounds(10, 10, 40, 26);

		lblNewLabel_3.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\navbar.png"));
		lblNewLabel_3.setBounds(10, 10, 32, 26);

		panel.add(lblNewLabel_3);
		
//		JLabel lblNewLabel_6 = new JLabel("");
//		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\hung\\Downloads\\nhuong-quyen-highland-coffee.png"));
//		lblNewLabel_6.setBounds(0, 5, 686, 303);
//		panel_2.add(lblNewLabel_6);
		

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\nhuong-quyen-highland-coffee.png"));
		lblNewLabel_6.setBounds(0, 5, 686, 303);
		
		panel_right = new JPanel();
		panel_right.setLayout(null);
		panel_right.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_right.setBackground(new Color(236, 255, 255));
		panel_right.setAlignmentY(0.0f);
		panel_right.setAlignmentX(1.0f);
		panel_right.setBounds(168, -1, 1214, 730);
		panel.add(panel_right);
		
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
