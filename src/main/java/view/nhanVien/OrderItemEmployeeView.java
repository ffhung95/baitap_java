package view.nhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.oderController;
import model.datHang;
import model.oderItem;
import view.trangChu.suaDonHangView;
import view.trangChu.themDonHangView;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderItemEmployeeView extends JFrame {
	private oderController odercontroller;
	private datHang dathang;
	private themDonHangView themdonhangview;
	private suaDonHangView suadonhangview;
	private JTable table;
	
	public OrderItemEmployeeView() {
		this.odercontroller = new oderController();
		
		this.suadonhangview= new suaDonHangView();
		this.themdonhangview = new themDonHangView();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		setTitle("Table");
    	this.setSize(700, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setResizable(false);
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 10, 559, 303);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        table = new JTable();
        table.setBounds(10, 10, 539, 283);
        panel.add(table);
        
        JButton btnNewButton = new JButton("Thêm");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		odercontroller.add(themdonhangview);
        	}
        });
       
        btnNewButton.setBounds(591, 128, 85, 36);
        getContentPane().add(btnNewButton);
        
        JButton btnCpNht = new JButton("Cập nhật");
        btnCpNht.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		odercontroller.edit(suadonhangview, dathang);
        	}
        });
        btnCpNht.setBounds(591, 185, 85, 36);
        getContentPane().add(btnCpNht);
		
	}
}
