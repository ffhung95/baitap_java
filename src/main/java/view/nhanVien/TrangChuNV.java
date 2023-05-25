package view.nhanVien;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TrangChuNV extends JFrame {
	public TrangChuNV() {
		this.initComponents();
        this.setVisible(true);
	}

	private void initComponents() {
		setTitle("Nhân Viên");
    	this.setSize(1100, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setResizable(false);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Chọn");
        lblNewLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	}
        });
        lblNewLabel.setBounds(226, 143, 45, 13);
        getContentPane().add(lblNewLabel);
		
	}
}
