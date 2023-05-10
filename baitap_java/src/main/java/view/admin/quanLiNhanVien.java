package view.admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.nhanVienModel;
import repository.NhanVienReposity;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

public class quanLiNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField hoten_jtfiel;
	private JTextField taikhoan_jtfiel;
	private JPasswordField matkhau_jpwfiel;
	private JTextField sdt_jtfiel;
	private JTextField ngayvaolam_jtfiel;
	private JTextField luong_jtfiel;
	private JTable table;
	private JComboBox chucvu_combobox;
	public quanLiNhanVien() {
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
        
        hoten_jtfiel = new JTextField();
        hoten_jtfiel.setBounds(106, 12, 159, 19);
        panel.add(hoten_jtfiel);
        hoten_jtfiel.setColumns(10);
        
        taikhoan_jtfiel = new JTextField();
        taikhoan_jtfiel.setColumns(10);
        taikhoan_jtfiel.setBounds(106, 45, 159, 19);
        panel.add(taikhoan_jtfiel);
        
        matkhau_jpwfiel = new JPasswordField();
        matkhau_jpwfiel.setBounds(106, 77, 159, 19);
        panel.add(matkhau_jpwfiel);
        
        sdt_jtfiel = new JTextField();
        sdt_jtfiel.setColumns(10);
        sdt_jtfiel.setBounds(481, 12, 159, 19);
        panel.add(sdt_jtfiel);
        
        ngayvaolam_jtfiel = new JTextField();
        ngayvaolam_jtfiel.setColumns(10);
        ngayvaolam_jtfiel.setBounds(481, 45, 159, 19);
        panel.add(ngayvaolam_jtfiel);
        
        chucvu_combobox = new JComboBox();
        chucvu_combobox.setModel(new DefaultComboBoxModel(new String[] {"", "Quản Lí", "Nhân Viên phục vụ"}));
        chucvu_combobox.setBounds(479, 76, 64, 21);
        panel.add(chucvu_combobox);
        
        luong_jtfiel = new JTextField();
        luong_jtfiel.setColumns(10);
        luong_jtfiel.setBounds(481, 109, 159, 19);
        panel.add(luong_jtfiel);
        
        JButton btnNewButton = new JButton("Thêm");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(hoten_jtfiel.getText().isEmpty() ||taikhoan_jtfiel.getText().isEmpty()||matkhau_jpwfiel.getPassword().toString().isEmpty()||
        			sdt_jtfiel.getText().isEmpty()||ngayvaolam_jtfiel.getText().isEmpty()||chucvu_combobox.getSelectedItem().toString().isEmpty()||luong_jtfiel.getText().isEmpty()) 
        		{
        			JOptionPane.showMessageDialog(null, "Không được để trống");
        		}
        		else {
        			nhanVienModel nhanVienModel = new nhanVienModel();
            		NhanVienReposity nhanVienRepository = new NhanVienReposity();

    				String hoten = hoten_jtfiel.getText();
    				nhanVienModel.setHoten(hoten);
    				String taikhoan = taikhoan_jtfiel.getText();
    				nhanVienModel.setTaikhoan(taikhoan);
    				String matkhau = new String(matkhau_jpwfiel.getPassword());
    				nhanVienModel.setMatkhau(matkhau);
    				String sdt = sdt_jtfiel.getText();
    				nhanVienModel.setSdt(sdt);
    				SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
    				String ngay= ngayvaolam_jtfiel.getText();
    				Date ngayvaolam = null;
    				try {
    					ngayvaolam = sdf.parse(ngay);
    				} catch (ParseException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
    				nhanVienModel.setNgayvaolam(ngayvaolam);
    				String chucvu = chucvu_combobox.getSelectedItem().toString();
    				nhanVienModel.setChucvu(chucvu);
    				int luong = Integer.parseInt(luong_jtfiel.getText());
    				nhanVienModel.setLuong(luong);
    				if (nhanVienRepository.kiemTraTenTenNhap(taikhoan) || nhanVienRepository.kiemTraSoDienThoai(sdt)) {
    					JOptionPane.showMessageDialog(null, "Tài khoản hay mật khẩu đã tồn tại");
    					xoaForm();
    				} else {
    					nhanVienRepository.insertUser(nhanVienModel);
    					if (nhanVienModel != null) {
    						JOptionPane.showMessageDialog(null, "Thêm thành công");
    					}
    				}
        		}
        		
        	}

			private void xoaForm() {
				hoten_jtfiel.setText("");
				taikhoan_jtfiel.setText("");
				matkhau_jpwfiel.setText("");
				sdt_jtfiel.setText("");
				ngayvaolam_jtfiel.setText("");
				luong_jtfiel.setText("");
				chucvu_combobox.setSelectedItem("");
			}
        });
        btnNewButton.setBounds(10, 109, 85, 21);
        panel.add(btnNewButton);
        
        JButton btnXa = new JButton("Xóa");
        btnXa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		deleteAdmin delete = new deleteAdmin();
        		delete.setVisible(true);
        	}
        });
        btnXa.setBounds(106, 108, 85, 21);
        panel.add(btnXa);
        
        JButton btnSa = new JButton("Cập nhật");
        btnSa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		capnhatAdmin capnhatView = new capnhatAdmin();
        		capnhatView.setVisible(true);
        	}
        });
        btnSa.setBounds(215, 108, 85, 21);
        panel.add(btnSa);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 189, 666, 124);
        getContentPane().add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Id", "Tên nhân viên", "SDT", "Ngày vào làm", "Chức vụ", "Lương"
        	}
        ));
        scrollPane.setViewportView(table);
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
}
