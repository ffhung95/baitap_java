package view.admin;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class menuView extends JFrame {

	private JPanel background;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuView frame = new menuView();
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
	public menuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1336, 751);
		background = new JPanel();
		background.setBackground(new Color(240, 240, 240));
		background.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(background);
		background.setLayout(null);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBounds(10, 10, 325, 729);
		background.add(panel_menu);
		panel_menu.setLayout(null);
		ImageIcon mainIcon = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\coffeeAdmin.png");
    	this.setIconImage(mainIcon.getImage());
	}
	
}
