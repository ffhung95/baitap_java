package view.nhanVien;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import model.hangHoa;
import model.table;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JLayeredPane;

public class hhhhh extends JFrame {
	private JPanel pmenu;
	private JPanel contentPane;
	private JPanel panel;
	private JSpinner spinner; 
	Map<Integer, Float > menuMap = new HashMap<>();
	private int valuess=0;
	private List<hangHoa> drinks;
    private List<table> desks;
    private List<JSpinner> mySpinners = new ArrayList<>();
	
	int width= 207;
	int height= 715;
	
	private float total = (float) 0.0;
    private int x=0;
    private float tax = (float)0.0;
	
	private final JSeparator separator = new JSeparator();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hhhhh frame = new hhhhh();
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
	public hhhhh() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1360, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(128, 255, 0));
		panel.setBounds(0, 38, 206, 715);
		contentPane.add(panel);
		closeMenuBar();
		
		
		
		JButton close = new JButton("");
		close.setBounds(0, 0, 50, 50);
		close.setBackground(new Color(128, 255, 0));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		close.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\cancel_close_delete_exit_logout_remove_x_icon_123217 - Copy.png"));
		panel.add(close);
		
		JButton btnNewButton_3_1 = new JButton("Log Out");
		btnNewButton_3_1.setBounds(0, 655, 207, 60);
		btnNewButton_3_1.setBackground(Color.WHITE);
		panel.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("Thông Tin");
		btnNewButton_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3_2.setBackground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				btnNewButton_3_2.setBackground(Color.WHITE);
			}
		});
		btnNewButton_3_2.setBounds(0, 575, 207, 60);
		btnNewButton_3_2.setBackground(Color.WHITE);
		panel.add(btnNewButton_3_2);
		separator.setBounds(0, 0, 0, 715);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(207, 0, 0, 715);
		panel.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		ImageIcon icon = new ImageIcon("C:\\Pic\\2.jpg");
        Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(53, 60, 80, 80);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Thành Ngọc Huy");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 150, 171, 35);
		panel.add(lblNewLabel_2);
		
		//panel.setVisible(false);
		
		
		JPanel pinfo = new JPanel();
		pinfo.setBounds(0, 38, 206, 715);
		contentPane.add(pinfo);
		
		JButton open = new JButton("");
		open.setIcon(new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\bar-menu_icon-icons.com_70305.png"));
		open.setBackground(new Color(128, 255, 0));
		open.setBounds(0, 0, 50, 50);
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//			panel.setVisible(true);
			pinfo.setVisible(false);
//			contentPane.add(panel);
				openMenuBar();
			
				
			}
		});
		pinfo.setLayout(null);
		pinfo.add(open);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			pinfo.setVisible(true);
//			panel.setVisible(false);
//			contentPane.add(panel_4);
				closeMenuBar();
			
				
			}
		});
		
//**************************************************************************		

		JPanel pban = new JPanel();
		pban.setBorder(new LineBorder(new Color(0, 0, 0)));
		pban.setBounds(206, 38, 1140, 715);
		contentPane.add(pban);
		pban.setLayout(null);
		
		JPanel pthongtin = new JPanel();
		pthongtin.setBorder(new LineBorder(new Color(0, 0, 0)));
		pthongtin.setBounds(690, 0, 450, 715);
		pban.add(pthongtin);
		pthongtin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin chi tiết");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(166, 10, 141, 31);
		pthongtin.add(lblNewLabel);
		
		JPanel pcacban = new JPanel();
		pcacban.setBackground(new Color(0,255,255));
		pcacban.setBorder(new LineBorder(Color.BLACK));
		pcacban.setBounds(0, 0, 690, 715);
		pban.add(pcacban);
		pcacban.setLayout(null);
		
		JLabel b7 = new JLabel("BÀN 7");
		b7.setBounds(50, 338, 186, 56);
		pcacban.add(b7);
		b7.setHorizontalAlignment(SwingConstants.CENTER);
		b7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b7.setBorder(new LineBorder(new Color(0,0,0)));
		
		JLabel b5 = new JLabel("BÀN 5");
		b5.setBounds(50, 242, 186, 56);
		pcacban.add(b5);
		b5.setHorizontalAlignment(SwingConstants.CENTER);
		b5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b5.setBorder(new LineBorder(new Color(0,0,0)));
		
		JLabel b3 = new JLabel("BÀN 3");
		b3.setBounds(50, 146, 186, 56);
		pcacban.add(b3);
		b3.setHorizontalAlignment(SwingConstants.CENTER);
		b3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b3.setBorder(new LineBorder(new Color(0,0,0)));
		
		JLabel b4 = new JLabel("BÀN 4");
		b4.setBounds(406, 146, 186, 56);
		pcacban.add(b4);
		b4.setHorizontalAlignment(SwingConstants.CENTER);
		b4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b4.setBorder(new LineBorder(new Color(0,0,0)));
		
		JLabel b6 = new JLabel("BÀN 6");
		b6.setBounds(406, 242, 186, 56);
		pcacban.add(b6);
		b6.setHorizontalAlignment(SwingConstants.CENTER);
		b6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b6.setBorder(new LineBorder(new Color(0,0,0)));
		
		JLabel b8 = new JLabel("BÀN 8");
		b8.setBounds(406, 338, 186, 56);
		pcacban.add(b8);
		b8.setHorizontalAlignment(SwingConstants.CENTER);
		b8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b8.setBorder(new LineBorder(new Color(0,0,0)));
		
		JLabel b10 = new JLabel("BÀN 10");
		b10.setBounds(406, 434, 186, 56);
		pcacban.add(b10);
		b10.setHorizontalAlignment(SwingConstants.CENTER);
		b10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b10.setBorder(new LineBorder(new Color(0,0,0)));
		
		JLabel b1 = new JLabel("BÀN 1");
		b1.setForeground(new Color(0, 0, 0));
		b1.setBackground(new Color(0, 255, 255));
		b1.setBounds(50, 50, 186, 56);
		pcacban.add(b1);
		b1.setHorizontalAlignment(SwingConstants.CENTER);
		b1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b1.setBorder(new LineBorder(new Color(0,0,0)));
		
		JLabel b2 = new JLabel("BÀN 2");
		b2.setBounds(406, 50, 186, 56);
		pcacban.add(b2);
		b2.setHorizontalAlignment(SwingConstants.CENTER);
		b2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b2.setBorder(new LineBorder(new Color(0,0,0)));
		
		JLabel b9 = new JLabel("BÀN 9");
		b9.setHorizontalAlignment(SwingConstants.CENTER);
		b9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b9.setBorder(new LineBorder(new Color(0,0,0)));
		b9.setBounds(50, 434, 186, 56);
		pcacban.add(b9);
		
		JPanel phead = new JPanel();
		phead.setBackground(new Color(128, 255, 0));
		phead.setBounds(0, 0, 1360, 38);
		contentPane.add(phead);
		phead.setLayout(null);
//*****************************************************************************************		
		JButton ban = new JButton("BÀN");
		ban.setBackground(new Color(0,255,255));
		ban.setHorizontalAlignment(SwingConstants.CENTER);
		ban.setBorder(new LineBorder(Color.black));
		ban.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ban.setBounds(206, 0, 121, 38);
		phead.add(ban);
		
		JButton menu = new JButton("MENU");
		menu.setBackground(new Color(128,255,0));
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setBorder(new LineBorder(Color.black));
		menu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menu.setBounds(327, 0, 121, 38);
		phead.add(menu);
		
		ban.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ban.setBackground(new Color(0,255,255));
				menu.setBackground(new Color(128,255,0));
				pmenu.setVisible(false);
				pban.setVisible(true);
			}
		});
		menu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ban.setBackground(new Color(128,255,0));
				menu.setBackground(new Color(0,255,255));
				contentPane.add(pmenu);
				pmenu.setVisible(true);
				pban.setVisible(false);
				
			}
		});
//*****************************************************************************************		
		JLabel ltime = new JLabel("");
		Date date = new Date();
        SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
        SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
        String time = tf.format(date);
        ltime.setText(time.split(" ")[0]+" "+time.split(" ")[1]);
        ltime.setText(df.format(date));
		
		ltime.setHorizontalAlignment(SwingConstants.CENTER);
        ltime.setFont(new Font("Tahoma", Font.ITALIC, 12));
        ltime.setBounds(0, 0, 206, 38);
        phead.add(ltime);
        
        JLabel ltime2 = new JLabel("");
        ltime2.setHorizontalAlignment(SwingConstants.CENTER);
        ltime2.setFont(new Font("Tahoma", Font.ITALIC, 14));
        ltime2.setBounds(486, 0, 164, 38);
        phead.add(ltime2);
        ltime2.setText(tf.format(date));
//*****************************************************************************************		
        GridBagConstraints gbcm= new GridBagConstraints();
        gbcm.gridx=0; gbcm.gridy=0;
        gbcm.ipadx=60; gbcm.ipady=20;
        gbcm.insets= new Insets(2, 2, 2, 2);
        pmenu= new JPanel();
        pmenu.setBounds(206, 38, 1140, 715);
        pmenu.setLayout(null);
        
        JPanel pMenu= new JPanel();
        pMenu.setBounds(0, 0, 844, 715);
        pmenu.add(pMenu);
        JPanel pBill= new JPanel();
        pBill.setBounds(844,0,296,715);
        pmenu.add(pBill);
        //contentPane.add(pmenu);
        JPanel menuarea= new JPanel(new BorderLayout());
        menuarea.setPreferredSize(new Dimension(844, 715));
        JPanel allmenu= new JPanel();
        allmenu.setPreferredSize(new Dimension(844,1000));
        allmenu.setLayout(new GridBagLayout());
        JScrollPane scr= new JScrollPane(allmenu);
        menuarea.add(scr, BorderLayout.CENTER);
        pMenu.add(menuarea);
        
        for(int i=1; i<10; i++) {
        	JPanel item= new JPanel();
        	item.setPreferredSize(new Dimension(210,70));
        	item.setLayout(new BorderLayout());
        	item.setBorder(new LineBorder(Color.BLACK));
        	JLabel imglb = new JLabel("");
			item.add(imglb, BorderLayout.WEST);
			ImageIcon itemicon = new ImageIcon("C:\\btl\\baitap_java\\src\\main\\resources\\images\\tra-hoa-hong-da.png");
			Image itemimg = itemicon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			
			imglb.setIcon(new ImageIcon(itemimg));
			
			JPanel textinfo= new JPanel();
			textinfo.setLayout(new GridLayout(2,1));
			JLabel name= new JLabel("Trà Đào Hoa Cúc"+i);
			name.setFont(new Font("Tahoma", Font.PLAIN, 14));
			name.setHorizontalAlignment(SwingConstants.CENTER);
			JLabel price = new JLabel("14000");
			price.setForeground(Color.orange);
			price.setFont(new Font("Tahoma", Font.PLAIN, 14));
			price.setHorizontalAlignment(SwingConstants.CENTER);
			textinfo.add(name);
			textinfo.add(price);
			
			JPanel soluong = new JPanel();
	       
	        soluong.setLayout(new BorderLayout(0, 0));
	        
	        spinner = new JSpinner();
	        soluong.add(spinner);
			
			item.add(imglb, BorderLayout.WEST);
			item.add(textinfo, BorderLayout.CENTER);
			item.add(soluong, BorderLayout.EAST);
        	allmenu.add(item, gbcm);
        	if(i%3==0) {
        		gbcm.gridx=0; gbcm.gridy++;
        	}else {
        		gbcm.gridx++;
        	}
        }
        
//*****************************************************************************************		
	}
	private void openMenuBar() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for( int i=0;i<height;i++) {
					panel.setSize(width,height);
				}
				
			}
		}).start();
		
	}
	private void closeMenuBar() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for( int i=width;i>0;i--) {
					panel.setSize(i,height);
				}
				
			}
		}).start();
	}
}
