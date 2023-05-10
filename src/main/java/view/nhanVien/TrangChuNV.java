package view.nhanVien;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.tableController;
import view.trangChu.tableView;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JTable;


public class TrangChuNV extends JFrame {

	public TrangChuNV() {

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
        panel.setBounds(10, 0, 202, 313);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("MENU");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(10, 10, 182, 67);
        panel.add(btnNewButton);
        
        JButton btnnHng = new JButton("Đơn Hàng");
        btnnHng.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		OrderItemEmployeeView view = new OrderItemEmployeeView();
        		view.setVisible(true);
        	}
        });
        btnnHng.setBounds(10, 73, 182, 82);
        panel.add(btnnHng);
        
        JButton btnHan = new JButton("Hóa đơn");
        btnHan.setBackground(new Color(255, 255, 255));
        btnHan.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        btnHan.setBounds(10, 153, 182, 74);
        panel.add(btnHan);
        
        JButton btnBn = new JButton("Bàn");
        btnBn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		TableEmployessWiew view= new TableEmployessWiew();
        		view.setVisible(true);
        		
        	}
        });
        btnBn.setBackground(Color.WHITE);
        btnBn.setBounds(10, 229, 182, 74);
        panel.add(btnBn);
      
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.activeCaption);
        panel_1.setBounds(214, 10, 462, 303);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
		
	}
}
