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
import javax.swing.SwingConstants;

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
		getContentPane().setBackground(new Color(236, 255, 255));
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
	        
	        JProgressBar progressBar = new JProgressBar();
	        progressBar.setMinimum(0);
	        progressBar.setMaximum(100);
	        progressBar.setForeground(new Color(51, 153, 204));
	        progressBar.setBackground(new Color(224, 255, 255));
	        progressBar.setBounds(0, 315, 687, 16);
	        getContentPane().add(progressBar);
	        Thread progressThread = new Thread(() -> {
	            try {
	                for (int i = 0; i <= 100; i++) {
	                    final int progressValue = i;
	                    javax.swing.SwingUtilities.invokeLater(() -> progressBar.setValue(progressValue));
	                    Thread.sleep(40);
	                }
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });
	        progressThread.start();
	        
	        JLabel lblNewLabel_1 = new JLabel("");
	        lblNewLabel_1.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\logo.png"));
	        lblNewLabel_1.setBounds(135, 0, 373, 265);
	        getContentPane().add(lblNewLabel_1);
		
	}
}
