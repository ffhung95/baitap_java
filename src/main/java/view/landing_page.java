package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;

public class landing_page extends JFrame {

	private JPanel contentPane;
	public JLabel loading;
	private JLabel lblNewLabel;
	public  JProgressBar MyprogressBar ;
	
	public landing_page() {
		getContentPane().setEnabled(false);
		loading = new JLabel();
		lblNewLabel = new JLabel();
		MyprogressBar = new JProgressBar();
		getContentPane().setForeground(new Color(230, 230, 250));
		getContentPane().setBackground(new Color(255, 255, 255));
		this.initComponents();
        this.setVisible(true);
	}

	private void initComponents() {
		
		 	setTitle("Loading....");
	    	this.setSize(700, 370);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
	        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	        this.setResizable(false);
	        getContentPane().setLayout(null);
	        
	        lblNewLabel = new JLabel("Highlands Coffee");
	        lblNewLabel.setBackground(new Color(0, 0, 0));
	        lblNewLabel.setForeground(new Color(0, 0, 0));
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblNewLabel.setBounds(226, 24, 198, 37);
	        getContentPane().add(lblNewLabel);
	        
	        loading = new JLabel("Loading.....");
	        loading.setForeground(new Color(0, 0, 0));
	        loading.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        loading.setBounds(283, 276, 119, 37);
	        getContentPane().add(loading);
	        
	        JProgressBar progressBar = new JProgressBar();
	        progressBar.setForeground(new Color(255, 51, 0));
	        progressBar.setBackground(new Color(224, 255, 255));
	        progressBar.setBounds(0, 315, 687, 20);
	        getContentPane().add(progressBar);
	        
	        JLabel lblNewLabel_1 = new JLabel("");
	        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hung\\eclipse-workspace\\baitap_java\\src\\main\\resources\\images\\higl.jfif"));
	        lblNewLabel_1.setBounds(199, 71, 225, 200);
	        getContentPane().add(lblNewLabel_1);
		
	}
}
