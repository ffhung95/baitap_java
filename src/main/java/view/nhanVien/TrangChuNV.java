package view.nhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class TrangChuNV extends JFrame {

	private JPanel contentPane;

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
        btnNewButton.setBounds(10, 10, 182, 67);
        panel.add(btnNewButton);
        
        JButton btnnHng = new JButton("Đơn Hàng");
        btnnHng.setBounds(10, 73, 182, 82);
        panel.add(btnnHng);
        
        JButton btnHan = new JButton("Hóa đơn");
        btnHan.setBounds(10, 153, 182, 74);
        panel.add(btnHan);
        
        JButton btnnHng_1_1 = new JButton("Vị trí bàn");
        btnnHng_1_1.setBounds(10, 224, 182, 89);
        panel.add(btnnHng_1_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.activeCaption);
        panel_1.setBounds(214, 10, 462, 303);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
		
	}
}
