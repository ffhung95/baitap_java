package window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ImageChooserExample extends JFrame implements ActionListener {

	 private JLabel imageLabel;

	    public ImageChooserExample() {
	        // Tạo cửa sổ JFrame
	        setTitle("Chọn ảnh");
	        setSize(400, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Tạo panel chứa nút chọn ảnh
	        JPanel buttonPanel = new JPanel();
	        JButton chooseImageButton = new JButton("Chọn ảnh");
	        chooseImageButton.addActionListener(this);
	        buttonPanel.add(chooseImageButton);

	        // Tạo label chứa ảnh
	        imageLabel = new JLabel();
	        add(imageLabel, BorderLayout.CENTER);
	        add(buttonPanel, BorderLayout.SOUTH);

	        // Hiển thị cửa sổ
	        setVisible(true);
	    }
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        JFileChooser fileChooser = new JFileChooser();
	        int result = fileChooser.showOpenDialog(this);

	        if (result == JFileChooser.APPROVE_OPTION) {
	            // Đọc tệp ảnh và cập nhật ảnh hiển thị trên label
	            File selectedFile = fileChooser.getSelectedFile();
	            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
	            Image image = imageIcon.getImage().getScaledInstance(300, -1, Image.SCALE_SMOOTH);
	            imageIcon = new ImageIcon(image);
	            imageLabel.setIcon(imageIcon);
	        }
	    }

	    public static void main(String[] args) {
	        new ImageChooserExample();
	    }

}
