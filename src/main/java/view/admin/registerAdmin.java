package view.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.Admin;
import repository.AdminReposity;
import utils.MaHoa;
import view.loginView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class registerAdmin extends JFrame {
	public File file;
	private JPanel panel;
	private JPanel panel_1;
	public JPanel contentPane;
	public JTextField taikhoan_jtfile;
	public JPasswordField matkhau_jpfile;
	public JTextField hoten_jtfile;
	public JTextField sdt_jtfile;
	public JLabel taikhoan_jlabel;
	public JLabel matkhau_jlabel;
	public JLabel hoten_jlabel;
	public JLabel sdt_jlabel;
	public JLabel avatar_jlabel;
	public JButton photo_jbutton;
	public JButton luu_jbutton;
	private JButton dangnhap_jbutton;
	private JTable thongtinadmin_table;
	

	public registerAdmin() {
		panel = new JPanel();
		panel_1 = new JPanel();
		taikhoan_jtfile = new JTextField();
		matkhau_jpfile = new JPasswordField();
		hoten_jtfile = new JTextField();
		sdt_jtfile = new JTextField();
		taikhoan_jlabel = new JLabel();
		matkhau_jlabel = new JLabel();
		hoten_jlabel = new JLabel();
		sdt_jlabel = new JLabel();
		avatar_jlabel = new JLabel();
		photo_jbutton = new JButton();
		contentPane = new JPanel();
		thongtinadmin_table = new JTable();
		this.init();
		this.setVisible(true);
		ImageIcon mainIcon = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\coffeeAdmin.png");
    	this.setIconImage(mainIcon.getImage());
	}

	private void init() {
		this.setTitle("Register");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(236, 255, 255));
		panel.setBounds(10, 46, 666, 615);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(236, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(28, 61, 486, 296);
		panel.add(panel_1);
		panel_1.setLayout(null);

		taikhoan_jlabel = new JLabel("Tài khoản :");
		taikhoan_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		taikhoan_jlabel.setBounds(26, 26, 85, 19);
		panel_1.add(taikhoan_jlabel);

		matkhau_jlabel = new JLabel("Mật khẩu :");
		matkhau_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		matkhau_jlabel.setBounds(26, 67, 73, 19);
		panel_1.add(matkhau_jlabel);

		hoten_jlabel = new JLabel("Họ tên :");
		hoten_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		hoten_jlabel.setBounds(26, 107, 73, 19);
		panel_1.add(hoten_jlabel);

		sdt_jlabel = new JLabel("SĐT :");
		sdt_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sdt_jlabel.setBounds(26, 144, 73, 19);
		panel_1.add(sdt_jlabel);

		avatar_jlabel = new JLabel("Avatar :");
		avatar_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		avatar_jlabel.setBounds(26, 184, 73, 19);
		panel_1.add(avatar_jlabel);

		taikhoan_jtfile = new JTextField();
		taikhoan_jtfile.setBounds(121, 27, 197, 19);
		panel_1.add(taikhoan_jtfile);
		taikhoan_jtfile.setColumns(10);

		hoten_jtfile = new JTextField();
		hoten_jtfile.setColumns(10);
		hoten_jtfile.setBounds(121, 108, 197, 19);
		panel_1.add(hoten_jtfile);

		sdt_jtfile = new JTextField();
		sdt_jtfile.setColumns(10);
		sdt_jtfile.setBounds(121, 144, 197, 19);
		panel_1.add(sdt_jtfile);

		
		photo_jbutton = new JButton("Browse....");
		photo_jbutton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel showImage = new JLabel("");
		showImage.setBounds(351, 184, 108, 82);
		photo_jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfilechoooser = new JFileChooser();
				jfilechoooser.setMultiSelectionEnabled(false);
				if (jfilechoooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					file = jfilechoooser.getSelectedFile();
//					
					ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
					Dimension labelSize = new Dimension(showImage.getWidth(), showImage.getHeight());
					ImageIcon scaledImageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(labelSize.width, labelSize.height, java.awt.Image.SCALE_SMOOTH));
					showImage.setIcon(scaledImageIcon);
					showImage.setPreferredSize(labelSize);
				}
			}
		});

//		showImage.setHorizontalAlignment(JLabel.CENTER); 
//		showImage.setVerticalAlignment(JLabel.CENTER);
		panel_1.add(showImage);
		photo_jbutton.setBounds(121, 183, 197, 21);
		panel_1.add(photo_jbutton);
		
		
		luu_jbutton = new JButton("Lưu");
		luu_jbutton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		luu_jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Admin adminmodel = new Admin();
					AdminReposity adminreposity = new AdminReposity();
					String taikhoan = taikhoan_jtfile.getText();
					adminmodel.setTaikhoan(taikhoan);
					String matkhau = new String(matkhau_jpfile.getPassword());
//					matkhau = MaHoa.toSHA1(matkhau);
					adminmodel.setMatkhau(matkhau);
					String hoten = hoten_jtfile.getText();
					adminmodel.setHoten(hoten);
					String sdt = sdt_jtfile.getText();
					adminmodel.setSdt(sdt);
					adminmodel.setAvatar(Files.readAllBytes(file.toPath()));
					if (adminreposity.kiemTraTenTenNhap(taikhoan) || adminreposity.kiemTraSoDienThoai(sdt)) {
						JOptionPane.showMessageDialog(null, "Tài khoản hay mật khẩu đã tồn tại");
						xoaForm();
					} else {
						adminreposity.insertUser(adminmodel);
						if (adminmodel != null) {
							JOptionPane.showMessageDialog(null, "Thêm thành công");
							loadTable();
						}

					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			private void xoaForm() {
				taikhoan_jtfile.setText("");
				matkhau_jpfile.setText("");
				hoten_jtfile.setText("");
				sdt_jtfile.setText("");

			}
		});
		luu_jbutton.setBounds(26, 246, 85, 21);
		panel_1.add(luu_jbutton);

		matkhau_jpfile = new JPasswordField();
		matkhau_jpfile.setBounds(121, 68, 197, 19);
		panel_1.add(matkhau_jpfile);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 404, 446, 180);
		scrollPane.getViewport().setBackground(new Color(255, 255, 255));
		panel.add(scrollPane);

		dangnhap_jbutton = new JButton("Đăng nhập");
		dangnhap_jbutton.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon iconReturn = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\return.png");
		dangnhap_jbutton.setIcon(iconReturn);
		dangnhap_jbutton.setBackground(new Color(10, 231, 231));
		dangnhap_jbutton.setForeground(new Color(255, 255, 255));
		dangnhap_jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginView loginview = new loginView();
				loginview.setVisible(true);

			}
		});
		dangnhap_jbutton.setBounds(28, 10, 124, 21);
		panel.add(dangnhap_jbutton);

		thongtinadmin_table = new JTable();
		thongtinadmin_table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Id", "New Họ tên", "SDT", "Avatar" }));
		scrollPane.setViewportView(thongtinadmin_table);

	}

	private void loadTable() {
		AdminReposity adminReposity = new AdminReposity();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Họ tên");
		defaultTableModel.addColumn("SDT");
		defaultTableModel.addColumn("Avatar");
		for (Admin adminModel : adminReposity.getAdmin()) {
			defaultTableModel.addRow(new Object[] { adminModel.getMaadmin(), adminModel.getHoten(), adminModel.getSdt(),
					adminModel.getAvatar() });
			thongtinadmin_table.setModel(defaultTableModel);
			thongtinadmin_table.getTableHeader().setReorderingAllowed(false);
			thongtinadmin_table.getColumnModel().getColumn(3).setCellRenderer(new ImageRender());
			thongtinadmin_table.setRowHeight(50);
		}

	}

	private class ImageRender extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int colum) {
			JLabel jlable = new JLabel();
			byte[] bytes = (byte[]) value;
			ImageIcon imageIcon = new ImageIcon(
					new ImageIcon(bytes).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			jlable.setIcon(imageIcon);
			return jlable;
		}
	}

}
