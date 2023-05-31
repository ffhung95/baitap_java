package view.admin;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
import java.awt.GridLayout;

public class quanLiNhanVien extends JPanel {

	private JPanel contentPane;
	private JTextField hoten_jtfiel;
	private JTextField taikhoan_jtfiel;
	private JPasswordField matkhau_jpwfiel;
	private JTextField sdt_jtfiel;
	private JTextField ngayvaolam_jtfiel;
	private JTextField luong_jtfiel;
	private JTable table;
	private JComboBox chucvu_combobox;
	private JPanel panel;
	public quanLiNhanVien() {
//		getContentPane().setBackground(new Color(236, 255, 255));
		this.initComponents();
        this.setVisible(true);
	}

	private void initComponents() {
		
    	this.setSize(1099, 655);
    	panel = new JPanel();
        
       
        panel.setBackground(new Color(236, 255, 255));
        panel.setBounds(0, 0, 1099, 655);
//        getContentPane().add(panel);
        panel.setLayout(null);
        
       
        JButton btnNewButton = new JButton("Thêm");
        btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		nhanVienModel nhanVienModel = new nhanVienModel();
        		NhanVienReposity nhanVienRepository = new NhanVienReposity();
				String hoten = hoten_jtfiel.getText();
				nhanVienModel.setHoten(hoten);
				String taikhoan = taikhoan_jtfiel.getText();
				nhanVienModel.setTaikhoan(taikhoan);
				String matkhau = new String(matkhau_jpwfiel.getPassword());
//				matkhau=MaHoa.toSHA1(matkhau);
				nhanVienModel.setMatkhau(matkhau);
				String sdt = sdt_jtfiel.getText();
				String regex= "^0[39]{1}\\d{8}$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(sdt);
				if(matcher.find()) {
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
							 loadtabel();
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Số điện thoại 10 số theo dạng 03-09 ");
					
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
        ImageIcon iconAdd = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\add.png");
        btnNewButton.setIcon(iconAdd);
        btnNewButton.setBounds(30, 170, 85, 21);
        panel.add(btnNewButton);
        
        JButton btnXa  = new JButton("Xóa");
        btnXa.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnXa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		NhanVienReposity nhanvienrepository= new NhanVienReposity();
        		nhanVienModel nhanvien = new nhanVienModel();
        		nhanvien.setManv(getMaNV());
        		nhanvienrepository.delete(nhanvien);
        		JOptionPane.showMessageDialog(null, "Xóa thành công");
        		loadtabel();
        	}
        });
        ImageIcon iconDelete = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\delete.png");
        btnXa.setIcon(iconDelete);
        btnXa.setBounds(230, 170, 85, 21);
        panel.add(btnXa);
        
        JButton btnSa = new JButton("Cập nhật");
        btnSa.setHorizontalAlignment(SwingConstants.LEFT);
        btnSa.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnSa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		capnhatAdmin capnhatView = new capnhatAdmin();
        		capnhatView.setVisible(true);
        	}
        });
        ImageIcon iconUpdate = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\update.png");
        btnSa.setIcon(iconUpdate);
        btnSa.setBounds(130, 170, 85, 21);
        panel.add(btnSa);
        
        JPanel TbNv= new JPanel();
        TbNv.setBounds(30,  200,  1060,  450);
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 0, 1060, 450);
        TbNv.add(scrollPane_1);
        panel.add(TbNv);
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setBounds(10, 189, 666, 124);
//        scrollPane.getViewport().setBackground(new Color(255, 255, 255));
//        getContentPane().add(scrollPane);
        
        table = new JTable();
        table.setFillsViewportHeight(true);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
//        table.setBackground(new Color(255, 255, 255));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Id", "Tên nhân viên", "SDT", "Ngày vào làm", "Chức vụ", "Lương"
        	}
        ));
        scrollPane_1.setViewportView(table);
        
        JButton btnNewButton_1 = new JButton("");
//        btnNewButton_1.setBackground(new Color(236, 255, 255));
        btnNewButton_1.setOpaque(false); 
        btnNewButton_1.setContentAreaFilled(false); 
        btnNewButton_1.getModel().setRollover(false);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//        		dispose();
        		trangChuAdmin tranchu = new trangChuAdmin();
        		tranchu.setVisible(true);
        	}
        });
        
        btnNewButton_1.setBounds(0, 0, 34, 21);
//        getContentPane().add(btnNewButton_1);
        btnNewButton_1.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\return.png"));
        
        JPanel NumperNum= new JPanel();
        NumperNum.setBounds(500,  30,  550,  150);
        NumperNum.setBackground(Color.white);
        NumperNum.setLayout(null);
       
        JPanel QlNpn= new JPanel();
        //QlNpn.setBorder(new LineBorder(Color.black));
        	JLabel QuanLyLa= new JLabel("QUẢN LÝ");
        	JLabel NumQuanLy= new JLabel("?/?");
        QlNpn.add(QuanLyLa);
        QlNpn.add(NumQuanLy);
        JPanel NvNpn= new JPanel();
        NvNpn.setBorder(new LineBorder(Color.black));
        	JLabel NhanVienLa= new JLabel("NHÂN VIÊN");
        	JLabel NumNhanVien= new JLabel("?/?");
        NvNpn.add(NhanVienLa);
        NvNpn.add(NumNhanVien);
        
        NumperNum.add(QlNpn);
        NumperNum.add(NvNpn);
        panel.add(NumperNum);
        
        
        
        
        
        
        loadtabel();
        this.add(panel);
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
			defaultTableModel.addRow(nhanvien.toRowTable());
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
