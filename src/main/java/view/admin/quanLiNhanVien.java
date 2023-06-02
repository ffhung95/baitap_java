package view.admin;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
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
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.record.cf.ColorGradientFormatting;

import model.nhanVienModel;
import repository.AdminReposity;
import repository.NhanVienReposity;
import utils.MaHoa;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.border.EtchedBorder;

public class quanLiNhanVien extends JPanel {
	public int tmp;
	private JTable table;
	private JComboBox chucvu_combobox;
	private JPanel panel;
	private JPanel AddArea;
	private JPanel ListArea;
	private JTextField hotenTF;
	private JTextField hotenTFUp;
	private JTextField taikhoanTF;
	private JTextField matkhauTF;
	private JTextField sdtTF;
	private JTextField sdtTFUp;
	private JTextField luongTF;
	private JTextField luongTFUp;
	private DateTextField datetf;
	private DateTextField datetfUp;
	private JComboBox chucvuCB;
	private JComboBox chucvuCBUp;
	private JPanel RegNVForm;
	private JPanel NumPerNum;
	private JPanel UpdateNVForm;
	public quanLiNhanVien() {
		this.initComponents();
        this.setVisible(true);
	}

	private void initComponents() {
		tmp=0;
    	this.setSize(1063, 642);
    	panel = new JPanel();
        panel.setBackground(new Color(225, 255, 255));
        panel.setBounds(0, 0, 1063, 642);
        panel.setLayout(null);
        JButton updateBut = new JButton("Cập nhật");
        	updateBut.setHorizontalAlignment(SwingConstants.LEFT);
        	updateBut.setFont(new Font("Tahoma", Font.PLAIN, 11));
        	ImageIcon iconUpdate = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\update.png");
        	updateBut.setIcon(iconUpdate);
        	
        JButton deleteButBut  = new JButton("Xóa");
        	deleteButBut.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
        saveBut.setFont(new Font("Tahoma", Font.PLAIN, 12));
        ImageIcon iconSave = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\save.png");
        saveBut.setIcon(iconSave);	
        	
//        JButton cancelBut= new JButton("Hủy");
//        cancelBut.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        cancelBut.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        	}
//        });
        	
        
        JButton addBut = new JButton("Thêm");
        	ImageIcon iconAdd = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\icons\\add.png");
        	addBut.setIcon(iconAdd);
	        addBut.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        
	        
	        addBut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tmp=2;
					NumPerNum.removeAll();
					NumPerNum.repaint();
					NumPerNum.add(RegNVForm);
					NumPerNum.repaint();
				}
			});
	        updateBut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tmp=1;
					NumPerNum.removeAll();
					NumPerNum.repaint();
					NumPerNum.add(UpdateNVForm);
					ConfirmId.setText("ID: "+getMaNV());
					NumPerNum.repaint();
				}
			});
//	        cancelBut.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					NumPerNum.removeAll();
//					NumPerNum.repaint();
//				}
//			});
	        saveBut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(tmp==1) {
        			nhanVienModel nhanVienModel= new nhanVienModel();
    				NhanVienReposity nhanVienRepository = new NhanVienReposity();
    				String hoten=hotenTFUp.getText();
    				String sdt= sdtTFUp.getText();
    				String ngay=datetfUp.getText();
    				String chucvu=chucvuCBUp.getSelectedItem().toString();
    				int luong =Integer.parseInt(luongTFUp.getText());
    				nhanVienModel.setHoten(hoten);
    				nhanVienModel.setSdt(sdt);
    				SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
    				Date ngayvaolam = null;
    				try {
    					ngayvaolam = sdf.parse(ngay);
    				} catch (ParseException e1) {
    					e1.printStackTrace();
    				}
    				nhanVienModel.setNgayvaolam(ngayvaolam);
    				nhanVienModel.setChucvu(chucvu);
    				nhanVienModel.setLuong(luong);
    				if(nhanVienModel!=null) {
    					nhanVienRepository.update(nhanVienModel);
    					loadtabel();
    					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
    				}else{
    					JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
    				}
        		}else {
        			nhanVienModel nhanVienModel = new nhanVienModel();
            		NhanVienReposity nhanVienRepository = new NhanVienReposity();
    				String hoten = hotenTF.getText();
    				nhanVienModel.setHoten(hoten);
    				String taikhoan = taikhoanTF.getText();
    				nhanVienModel.setTaikhoan(taikhoan);
    				String matkhau = matkhauTF.getText();
    				nhanVienModel.setMatkhau(matkhau);
    				String sdt = sdtTF.getText();
    				String regex= "^0[39]{1}\\d{8}$";
    				Pattern pattern = Pattern.compile(regex);
    				Matcher matcher = pattern.matcher(sdt);
    				if(matcher.find()) {
    					nhanVienModel.setSdt(sdt);
    					SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
    					String ngay= datetf.getText();
    					Date ngayvaolam = null;
    					try {
    						ngayvaolam = sdf.parse(ngay);
    					} catch (ParseException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					nhanVienModel.setNgayvaolam(ngayvaolam);
    					String chucvu = chucvuCB.getSelectedItem().toString();
    					nhanVienModel.setChucvu(chucvu);
    					int luong = Integer.parseInt(luongTF.getText());
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
        		
        	}
			private void xoaForm() {
				hotenTF.setText("");
				taikhoanTF.setText("");
				matkhauTF.setText("");
				sdtTF.setText("");
				
				luongTF.setText("");
				chucvuCB.setSelectedItem("");
			}
        });
	        addBut.setBounds(30, 30, 100, 30);
	        deleteButBut.setBounds(163, 90, 100, 30);
	        saveBut.setBounds(30, 90, 100, 30);
	        updateBut.setBounds(163, 31, 100, 30);
//	        cancelBut.setBounds(101, 149, 100, 30);
        panel.add(addBut);
        panel.add(updateBut);
        panel.add(deleteButBut);
        panel.add(saveBut);
//        panel.add(cancelBut);
        
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
  //******DK NV******************************************************      
        NumPerNum= new JPanel();
        NumPerNum.setBounds(273,  0,  780,  190);
        
        NumPerNum.setBackground(new Color(236, 255, 255));
        NumPerNum.setLayout(null);
        
        RegNVForm= new JPanel();
        TitledBorder bdreg= new TitledBorder("Tạo Tài Khoản Nhân Viên");
        bdreg.setTitleJustification(TitledBorder.CENTER);
        RegNVForm.setBounds(273,  0,  780,  190);
        RegNVForm.setBorder(new TitledBorder(bdreg));
        RegNVForm.setBounds(0,  0,  780,  190);
        RegNVForm.setBackground(new Color(225, 255, 255));
        	RegNVForm.setLayout(null);
        
        	JLabel nameLable= new JLabel("Họ Tên :");
        	nameLable.setHorizontalAlignment(SwingConstants.LEFT);
        	nameLable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        	nameLable.setBounds(20, 30, 80, 30);
        	RegNVForm.add(nameLable);
        
        JLabel lblTiKhon = new JLabel("Tài Khoản :");
        lblTiKhon.setHorizontalAlignment(SwingConstants.LEFT);
        lblTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTiKhon.setBounds(20, 85, 80, 30);
        RegNVForm.add(lblTiKhon);
        
        JLabel lblMtKhu = new JLabel("Mật Khẩu :");
        lblMtKhu.setHorizontalAlignment(SwingConstants.LEFT);
        lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMtKhu.setBounds(20, 140, 80, 30);
        RegNVForm.add(lblMtKhu);
        
        hotenTF = new JTextField();
        hotenTF.setFont(new Font("Tahoma", Font.PLAIN, 12));
        hotenTF.setBounds(110, 30, 149, 30);
        RegNVForm.add(hotenTF);
        hotenTF.setColumns(10);
        
        taikhoanTF = new JTextField();
        taikhoanTF.setFont(new Font("Tahoma", Font.PLAIN, 12));
        taikhoanTF.setColumns(10);
        taikhoanTF.setBounds(110, 85, 149, 30);
        RegNVForm.add(taikhoanTF);
        
        matkhauTF = new JTextField();
        matkhauTF.setFont(new Font("Tahoma", Font.PLAIN, 12));
        matkhauTF.setColumns(10);
        matkhauTF.setBounds(110, 140, 149, 30);
        RegNVForm.add(matkhauTF);
        
        JLabel lblSinThoi = new JLabel("Số Điện Thoại :");
        lblSinThoi.setHorizontalAlignment(SwingConstants.CENTER);
        lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSinThoi.setBounds(290, 30, 100, 30);
        RegNVForm.add(lblSinThoi);
        
        JLabel lblLng = new JLabel("Lương :");
        lblLng.setHorizontalAlignment(SwingConstants.LEFT);
        lblLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblLng.setBounds(290, 140, 100, 30);
        RegNVForm.add(lblLng);
        
        JLabel lblChcV = new JLabel("Chức Vụ :");
        lblChcV.setHorizontalAlignment(SwingConstants.LEFT);
        lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblChcV.setBounds(584, 30, 69, 30);
        RegNVForm.add(lblChcV);
        
        sdtTF = new JTextField();
        sdtTF.setFont(new Font("Tahoma", Font.PLAIN, 12));
        sdtTF.setColumns(10);
        sdtTF.setBounds(401, 30, 149, 26);
        RegNVForm.add(sdtTF);
        
        luongTF = new JTextField();
        luongTF.setFont(new Font("Tahoma", Font.PLAIN, 12));
        luongTF.setColumns(10);
        luongTF.setBounds(401, 144, 149, 30);
        RegNVForm.add(luongTF);
        
        chucvuCB = new JComboBox();
        chucvuCB.setFont(new Font("Tahoma", Font.PLAIN, 12));
        chucvuCB.setModel(new DefaultComboBoxModel(new String[] {"Quản Lý", "Nhân Viên Phục Vụ"}));
        chucvuCB.setBounds(658, 30, 100, 30);
        RegNVForm.add(chucvuCB);
        datetf= new DateTextField();
        datetf.setBackground(new Color(255, 255, 255));
        datetf.setFont(new Font("Tahoma", Font.ITALIC, 12));
        datetf.setHorizontalAlignment(SwingConstants.CENTER);
        datetf.setBounds(401, 85, 149, 30);
        RegNVForm.add(datetf);
        
        JLabel lblNewLabel = new JLabel("Ngày Vào Làm :");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(290, 85, 100, 30);
        RegNVForm.add(lblNewLabel);
  //******CN NV**********************************************************8      
        UpdateNVForm= new JPanel();
        TitledBorder bd= new TitledBorder("Cập Nhật Thông Tin");
        bd.setTitleJustification(TitledBorder.CENTER);
        UpdateNVForm.setBackground(new Color(225, 255, 255));
        UpdateNVForm.setBorder(bd);
        UpdateNVForm.setBounds(0,  0,  780,  190);
        UpdateNVForm.setLayout(null);
        
        JLabel nameLableUp= new JLabel("Họ Tên :");
        nameLableUp.setHorizontalAlignment(SwingConstants.LEFT);
        nameLableUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameLableUp.setBounds(20, 30, 80, 30);
        UpdateNVForm.add(nameLableUp);
        
    	 hotenTFUp = new JTextField();
    	 hotenTFUp.setBounds(110, 30, 139, 30);
    	 UpdateNVForm.add(hotenTFUp);
         hotenTFUp.setColumns(10);
         
         JLabel lblSinThoiUp = new JLabel("Số điện thoại :");
         lblSinThoiUp.setHorizontalAlignment(SwingConstants.LEFT);
         lblSinThoiUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
         lblSinThoiUp.setBounds(291, 30, 100, 30);
         UpdateNVForm.add(lblSinThoiUp);
         
         JLabel lblLngUp = new JLabel("Lương :");
         lblLngUp.setHorizontalAlignment(SwingConstants.LEFT);
         lblLngUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
         lblLngUp.setBounds(564, 30, 65, 30);
         UpdateNVForm.add(lblLngUp);
         
         JLabel lblChcVUp = new JLabel("Chức Vụ :");
         lblChcVUp.setHorizontalAlignment(SwingConstants.LEFT);
         lblChcVUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
         lblChcVUp.setBounds(20, 85, 80, 30);
         UpdateNVForm.add(lblChcVUp);
         
         sdtTFUp = new JTextField();
         sdtTFUp.setColumns(10);
         sdtTFUp.setBounds(401, 30, 139, 30);
         UpdateNVForm.add(sdtTFUp);
         
         luongTFUp = new JTextField();
         luongTFUp.setColumns(10);
         luongTFUp.setBounds(631, 30, 139, 30);
         UpdateNVForm.add(luongTFUp);
         
         chucvuCBUp = new JComboBox();
         chucvuCBUp.setFont(new Font("Tahoma", Font.PLAIN, 12));
         chucvuCBUp.setModel(new DefaultComboBoxModel(new String[] {"Quản Lý", "Nhân Viên Phục Vụ"}));
         chucvuCBUp.setBounds(110, 85, 139, 30);
         UpdateNVForm.add(chucvuCBUp);
        
         JLabel lblNewLabelUp = new JLabel("Ngày Vào Làm :");
         lblNewLabelUp.setHorizontalAlignment(SwingConstants.LEFT);
         lblNewLabelUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
         lblNewLabelUp.setBounds(290, 85, 100, 30);
         UpdateNVForm.add(lblNewLabelUp);
         
         datetfUp= new DateTextField();
         datetfUp.setBackground(new Color(255, 255, 255));
         datetfUp.setFont(new Font("Tahoma", Font.ITALIC, 12));
         datetfUp.setHorizontalAlignment(SwingConstants.CENTER);
         datetfUp.setBounds(401, 85, 139, 30);
         UpdateNVForm.add(datetfUp);
    //****ViewBasic**************************************************************8
         NPN= new JPanel();
         NPN.setBounds(0,  0,  780,  190);
         
         
         
         
        
         
        NumPerNum.add(RegNVForm);
        
        JLabel lblangCpNht = new JLabel("Đang Cập Nhật :");
        lblangCpNht.setHorizontalAlignment(SwingConstants.LEFT);
        lblangCpNht.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblangCpNht.setBounds(20, 132, 110, 30);
        UpdateNVForm.add(lblangCpNht);
        
        ConfirmId = new JLabel("ID: 0");
        ConfirmId.setHorizontalAlignment(SwingConstants.LEFT);
        ConfirmId.setFont(new Font("Tahoma", Font.PLAIN, 12));
        ConfirmId.setBounds(140, 130, 139, 30);
        ConfirmId.setFont(new Font("ARIA", Font.BOLD, 20));
        UpdateNVForm.add(ConfirmId);
        NPN.setLayout(null);
        
        JPanel panel_1 = new JPanel();
      //  panel_1.getColorModel(new ColorGradientFormatting(new Co));
        panel_1.setBackground(new Color(255,  38,  123, 20));
        panel_1.setBounds(91, 0, 190, 190);
        NPN.add(panel_1);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBounds(492, 0, 190, 190);
        NPN.add(panel_1_1);
        panel.add(NumPerNum);
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
	private JPanel NPN;
	private JLabel ConfirmId;

}