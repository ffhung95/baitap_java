package view.nhanVien;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JSpinner;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class hhhha extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hhhha frame = new hhhha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public hhhha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1140, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 844, 750);
		panel.setLayout(new BorderLayout());
		
//*************************************************************************************		
		JPanel menupane= new JPanel();
		menupane.setLayout(new GridBagLayout());
		JScrollPane ctp= new JScrollPane(menupane);
		panel.add(ctp, BorderLayout.CENTER);
		contentPane.add(panel);
		menupane.setPreferredSize(new Dimension(854,1400));
		GridBagConstraints gbc= new GridBagConstraints();
		gbc.fill= GridBagConstraints.PAGE_START;
		gbc.ipadx=60; gbc.ipady=20;
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets= new Insets(2, 2, 2, 2);
		for(int i=1; i<100; i++) {
			JPanel menuform = new JPanel();
			menuform.setBorder(new LineBorder(new Color(0, 0, 0)));
			menuform.setLayout(new BorderLayout());
			
			JLabel imglb = new JLabel("");
			menuform.add(imglb, BorderLayout.WEST);
			ImageIcon icon = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\tra-hoa-hong-da.png");
			Image img = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			
			imglb.setIcon(new ImageIcon(img));
			
			JPanel textinfo= new JPanel();
			textinfo.setLayout(new GridLayout(2,1));
			JLabel name= new JLabel("Trà Đào Hoa Cúc");
			name.setFont(new Font("Tahoma", Font.PLAIN, 14));
			name.setHorizontalAlignment(SwingConstants.CENTER);
			JLabel price = new JLabel("14000");
			price.setForeground(Color.orange);
			price.setFont(new Font("Tahoma", Font.PLAIN, 14));
			price.setHorizontalAlignment(SwingConstants.CENTER);
			textinfo.add(name);
			textinfo.add(price);
			menuform.add(textinfo, BorderLayout.CENTER);

	        JPanel panel_3 = new JPanel();
	        menuform.add(panel_3, BorderLayout.EAST);
	        panel_3.setLayout(new BorderLayout(0, 0));
	        
	        JSpinner spinner = new JSpinner();
	        panel_3.add(spinner);
	        menupane.add(menuform, gbc);
	        if(i%3==0) {
	        	gbc.gridx=0; gbc.gridy++;
	        }else {
	        	gbc.gridx++;
	        }
		}
//************************************************************************************		
		for(int i=0; i<12; i++) {
			
		}
		
		
//************************************************************************************		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(840, 0, 300, 715);
		contentPane.add(panel_1);
	}
}
