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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
	private JPanel AddArea;
	private JPanel ListArea;
	private JTextField hotenTF;
	private JTextField taikhoanTF;
	private JTextField matkhauTF;
	private JTextField sdtTF;
	private JTextField luongTF;
	public quanLiNhanVien() {
		this.initComponents();
        this.setVisible(true);
	}

	private void initComponents() {
    	this.setSize(1063, 642);
    	panel = new JPanel();
        panel.setBackground(new Color(236, 255, 255));
        panel.setBounds(0, 0, 1063, 642);
        panel.setLayout(null);
        JButton updateBut = new JButton("Cập nhật");
        	updateBut.setHorizontalAlignment(SwingConstants.LEFT);
        	updateBut.setFont(new Font("Tahoma", Font.PLAIN, 11));
        	updateBut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		capnhatAdmin capnhatView = new capnhatAdmin();
        		capnhatView.setVisible(true);
        	}
        	});
        	ImageIcon iconUpdate = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\update.png");
        	updateBut.setIcon(iconUpdate);
        	
        JButton deleteButBut  = new JButton("Xóa");
        	deleteButBut.setFont(new Font("Tahoma", Font.PLAIN, 11));
        	deleteButBut.addActionListener(new ActionListener() {
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
        	deleteButBut.setIcon(iconDelete);
        	
        
        
        JButton saveBut= new JButton("Lưu");
        saveBut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        	
        	
        JButton cancelBut= new JButton("Hủy");
        cancelBut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        	
        
        JButton addBut = new JButton("Thêm");
        	ImageIcon iconAdd = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\add.png");
        	addBut.setIcon(iconAdd);
        	
	        	addBut.setHorizontalAlignment(SwingConstants.LEFT);
	        addBut.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        addBut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		nhanVienModel nhanVienModel = new nhanVienModel();
        		NhanVienReposity nhanVienRepository = new NhanVienReposity();
				String hoten = hoten_jtfiel.getText();
				nhanVienModel.setHoten(hoten);
				String taikhoan = taikhoan_jtfiel.getText();
				nhanVienModel.setTaikhoan(taikhoan);
				String matkhau = new String(matkhau_jpwfiel.getPassword());
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
	        addBut.setBounds(30, 30, 100, 30);
	        deleteButBut.setBounds(163, 90, 100, 30);
	        saveBut.setBounds(163, 30, 100, 30);
	        updateBut.setBounds(30, 90, 100, 30);
	        cancelBut.setBounds(101, 149, 100, 30);
        panel.add(addBut);
        panel.add(updateBut);
        panel.add(deleteButBut);
        panel.add(saveBut);
        panel.add(cancelBut);
        
        JPanel TbNv= new JPanel();
        TbNv.setBounds(30,  200,  1023,  450);
        TbNv.setLayout(new BorderLayout());
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 0, 1000, 450);
        TbNv.add(scrollPane_1, BorderLayout.CENTER);
        //ListArea.add(scrollPane_1, BorderLayout.CENTER);
        
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
        
        JButton addBut_1 = new JButton("");
//        addBut_1.setBackground(new Color(236, 255, 255));
        addBut_1.setOpaque(false); 
        addBut_1.setContentAreaFilled(false); 
        addBut_1.getModel().setRollover(false);
        addBut_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//        		dispose();
        		trangChuAdmin tranchu = new trangChuAdmin();
        		tranchu.setVisible(true);
        	}
        });
        
        addBut_1.setBounds(0, 0, 34, 21);
//        getContentPane().add(addBut_1);
        addBut_1.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\return.png"));
        
        JPanel NumperNum= new JPanel();
        NumperNum.setBounds(273,  10,  780,  180);
        NumperNum.setBackground(Color.white);
        	NumperNum.setLayout(null);
        
        	JLabel nameLable= new JLabel("Họ Tên");
        	nameLable.setHorizontalAlignment(SwingConstants.CENTER);
        	nameLable.setFont(new Font("Tahoma", Font.PLAIN, 12));
        	nameLable.setBounds(0, 0, 100, 50);
        	NumperNum.add(nameLable);
      
        panel.add(NumperNum);
        
        JLabel lblTiKhon = new JLabel("Tài Khoản");
        lblTiKhon.setHorizontalAlignment(SwingConstants.CENTER);
        lblTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTiKhon.setBounds(0, 60, 100, 50);
        NumperNum.add(lblTiKhon);
        
        JLabel lblMtKhu = new JLabel("Mật Khẩu");
        lblMtKhu.setHorizontalAlignment(SwingConstants.CENTER);
        lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblMtKhu.setBounds(0, 124, 100, 50);
        NumperNum.add(lblMtKhu);
        
        hotenTF = new JTextField();
        hotenTF.setBounds(110, 10, 139, 26);
        NumperNum.add(hotenTF);
        hotenTF.setColumns(10);
        
        taikhoanTF = new JTextField();
        taikhoanTF.setColumns(10);
        taikhoanTF.setBounds(110, 74, 139, 26);
        NumperNum.add(taikhoanTF);
        
        matkhauTF = new JTextField();
        matkhauTF.setColumns(10);
        matkhauTF.setBounds(110, 138, 139, 26);
        NumperNum.add(matkhauTF);
        
        JLabel lblSinThoi = new JLabel("Số Điện Thoại");
        lblSinThoi.setHorizontalAlignment(SwingConstants.CENTER);
        lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSinThoi.setBounds(291, 0, 100, 50);
        NumperNum.add(lblSinThoi);
        
        JLabel lblLng = new JLabel("Lương");
        lblLng.setHorizontalAlignment(SwingConstants.CENTER);
        lblLng.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblLng.setBounds(291, 60, 100, 50);
        NumperNum.add(lblLng);
        
        JLabel lblChcV = new JLabel("Chức Vụ");
        lblChcV.setHorizontalAlignment(SwingConstants.CENTER);
        lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblChcV.setBounds(291, 124, 100, 50);
        NumperNum.add(lblChcV);
        
        sdtTF = new JTextField();
        sdtTF.setColumns(10);
        sdtTF.setBounds(401, 10, 139, 26);
        NumperNum.add(sdtTF);
        
        luongTF = new JTextField();
        luongTF.setColumns(10);
        luongTF.setBounds(401, 74, 139, 26);
        NumperNum.add(luongTF);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(569, 10, 201, 164);
        panel_1.setLayout(null);
        NumperNum.add(panel_1);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Quản Lý", "Nhân Viên Phục Vụ"}));
        comboBox.setBounds(401, 137, 139, 26);
        NumperNum.add(comboBox);
        DateTextField datetf= new DateTextField();
        datetf.setBounds(255, 42, 100, 30);
        NumperNum.add(datetf);
        
        
        
        
        
        
        loadtabel();
        setLayout(null);
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
