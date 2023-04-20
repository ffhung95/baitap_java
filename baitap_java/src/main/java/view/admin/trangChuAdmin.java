package view.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class trangChuAdmin extends JFrame {

	public trangChuAdmin() {
		this.initComponents();
        this.setVisible(true);
	}

	private void initComponents() {
		setTitle("ADMIN");
    	this.setSize(700, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setResizable(false);
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 255, 255));
        panel.setBounds(10, 10, 200, 303);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("Quản Lí Nhân Viên");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		quanLiNhanVien nhanvienView= new quanLiNhanVien();
        		nhanvienView.setVisible(true);
        	}
        });
        btnNewButton.setBounds(0, 10, 200, 58);
        panel.add(btnNewButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(215, 10, 461, 303);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
		
	}

}
