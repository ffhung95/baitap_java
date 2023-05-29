package view.admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.nhanVienModel;
import repository.AdminReposity;
import repository.NhanVienReposity;
import utils.MaHoa;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class quanLiNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public JPanel panelNhanvien;
	public quanLiNhanVien() {
		getContentPane().setBackground(new Color(236, 255, 255));
		this.initComponents();
        this.setVisible(true);
	}

	private void initComponents() {
		setTitle("Nhân Viên");
    	this.setSize(1214, 730);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setResizable(false);
        getContentPane().setLayout(null);
        ImageIcon iconAdd = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\add.png");
        ImageIcon iconDelete = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\delete.png");
        ImageIcon iconUpdate = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\update.png");
        
        panelNhanvien = new JPanel();
        panelNhanvien.setLayout(null);
        panelNhanvien.setBackground(new Color(236, 255, 255));
        panelNhanvien.setBounds(0, 0, 1200, 693);
        getContentPane().add(panelNhanvien);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(236, 255, 255));
        panel.setBounds(0, 35, 1200, 259);
        panelNhanvien.add(panel);
        
        JLabel lblNewLabel = new JLabel("Tên nhân viên :");
        lblNewLabel.setBounds(10, 10, 86, 22);
        panel.add(lblNewLabel);
        
        JLabel lblTiKhon = new JLabel("Tài khoản :");
        lblTiKhon.setBounds(10, 43, 86, 22);
        panel.add(lblTiKhon);
        
        JLabel lblMtKhu = new JLabel("Mật khẩu :");
        lblMtKhu.setBounds(10, 75, 86, 22);
        panel.add(lblMtKhu);
        
        JLabel lblSdt = new JLabel("SĐT :");
        lblSdt.setBounds(349, 10, 36, 22);
        panel.add(lblSdt);
        
        JLabel lblNgyVoLm = new JLabel("Ngày vào làm :");
        lblNgyVoLm.setBounds(349, 43, 86, 22);
        panel.add(lblNgyVoLm);
        
        JLabel lblChcV = new JLabel("Chức vụ :");
        lblChcV.setBounds(349, 75, 55, 22);
        panel.add(lblChcV);
        
        JLabel lblLng = new JLabel("Lương :");
        lblLng.setBounds(349, 108, 55, 22);
        panel.add(lblLng);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(106, 12, 182, 19);
        panel.add(textField);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(106, 45, 182, 19);
        panel.add(textField_1);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(106, 77, 182, 19);
        panel.add(passwordField);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(439, 11, 183, 19);
        panel.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(439, 44, 183, 19);
        panel.add(textField_3);
        
        JComboBox chucvu_combobox = new JComboBox();
        chucvu_combobox.setBounds(439, 76, 100, 21);
        panel.add(chucvu_combobox);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(439, 109, 183, 19);
        panel.add(textField_4);
        
        JButton btnNewButton = new JButton("Thêm");
        btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnNewButton.setBounds(10, 107, 85, 21);
        panel.add(btnNewButton);
        
        JButton btnXa = new JButton("Xóa");
        btnXa.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnXa.setBounds(106, 108, 85, 21);
        panel.add(btnXa);
        
        JButton btnSa = new JButton("Cập nhật");
        btnSa.setHorizontalAlignment(SwingConstants.LEFT);
        btnSa.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnSa.setBounds(203, 108, 85, 21);
        panel.add(btnSa);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 363, 1200, 330);
        panelNhanvien.add(scrollPane);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setBackground(Color.RED);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1.setOpaque(false);
        btnNewButton_1.setContentAreaFilled(false);
        btnNewButton_1.setBounds(0, 10, 48, 22);
        panelNhanvien.add(btnNewButton_1);
        loadtabel();
		
	}
	private void loadtabel() {
		NhanVienReposity nhanVienReposity= new NhanVienReposity();
		DefaultTableModel defaultTableModel= new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Họ tên");
		defaultTableModel.addColumn("SDT");
		defaultTableModel.addColumn("Ngày vào làm");
		defaultTableModel.addColumn("Chức vụ");
		defaultTableModel.addColumn("Lương");
		for (nhanVienModel nhanvien : nhanVienReposity.getAdmin()) {
			defaultTableModel.addRow(new Object[] {
					nhanvien.getManv(),
					nhanvien.getHoten(),
					nhanvien.getSdt(),
					nhanvien.getNgayvaolam().getDate()+"/"+(nhanvien.getNgayvaolam().getMonth()+1)+"/"+(nhanvien.getNgayvaolam().getYear()+1900),
					nhanvien.getChucvu(),
					nhanvien.getLuong(),
								});
			table.setModel(defaultTableModel);
			table.getTableHeader().setReorderingAllowed(false);	
		}
	}
	public int getMaNV() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int mannv = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		return mannv;
	}
}
