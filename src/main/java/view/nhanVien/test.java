package view.nhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test extends JFrame {
	public test() {
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
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(591, 45, 85, 36);
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.setBounds(591, 128, 85, 36);
        getContentPane().add(btnNewButton_1);
		
	}

}
