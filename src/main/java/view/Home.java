package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {
	int width=158;
	int height= 360;
	private JPanel contentPane;
	private JPanel panel_1;
// width 158
//height 360
/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 10, 638, 360);
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
		separator.setBounds(0, 98, 158, 2);
		panel_1.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Trang chủ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(32, 110, 96, 29);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tài khoản");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(32, 149, 96, 29);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Hóa Đơn");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(32, 188, 96, 29);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Thống kê");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(32, 227, 96, 29);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 266, 158, 2);
		panel_1.add(separator_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Đăng xuất");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(32, 321, 96, 29);
		panel_1.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Trợ giúp");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_1.setBounds(32, 282, 96, 29);
		panel_1.add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openMenuBar();			}

			
		});
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\hung\\Downloads\\bar-menu_icon-icons.com_70305.png"));
		lblNewLabel_3.setBounds(23, 22, 53, 26);
		panel.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 240, 240));
		panel_2.setBounds(0, 58, 628, 292);
		panel.add(panel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Trang chủ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_4);
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
