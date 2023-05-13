package view.trangChu;

import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.hangHoa;
import model.loaiHang;

import repository.loaiHangHoaRepository;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;

public class hangHoaView extends JFrame {

	DefaultComboBoxModel<loaiHang> foodCategoryComboBoxModel = new DefaultComboBoxModel<>();
	loaiHangHoaRepository LoaiHangRepo = new loaiHangHoaRepository();

	public hangHoaView() {
		LoaiHangRepo = new loaiHangHoaRepository();
		initComponents();
		setLocationRelativeTo(null);
		cboCategory.setModel(foodCategoryComboBoxModel);
	}

	

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public JButton getBtnChooseImage() {
		return btnChooseImage;
	}

	public void setBtnChooseImage(JButton btnChooseImage) {
		this.btnChooseImage = btnChooseImage;
	}

	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}

	public JComboBox<loaiHang> getCboCategory() {
		return cboCategory;
	}

	public void setCboCategory(JComboBox<loaiHang> cboCategory) {
		this.cboCategory = cboCategory;
	}

	public JLabel getLbTitle() {
		return lbTitle;
	}

	public void setLbTitle(JLabel lbTitle) {
		this.lbTitle = lbTitle;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JTextField getTxtUnitPrice() {
		return txtUnitPrice;
	}
	
	
	public void setSoLuong(JTextField textField_soluong) {
		this.textField_soluong = textField_soluong;
	}

	public JTextField getTxtSoLuong() {
		return textField_soluong;
	}

	public void setTxtUnitPrice(JTextField txtUnitPrice) {
		this.txtUnitPrice = txtUnitPrice;
	}

	

	public DefaultComboBoxModel<loaiHang> getFoodCategoryComboBoxModel() {
		return foodCategoryComboBoxModel;
	}

	public void setFoodCategoryComboBoxModel(DefaultComboBoxModel<loaiHang> foodCategoryComboBoxModel) {
		this.foodCategoryComboBoxModel = foodCategoryComboBoxModel;
	}

	public JLabel getLbPreviewImage() {
		return lbPreviewImage;
	}

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;
		jPanel1 = new javax.swing.JPanel();
		lbTitle = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		btnOK = new javax.swing.JButton();
//        btnOK.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        		hangHoa foodItem = new hangHoa();
//        			try {
//						for (loaiHang loaihang : LoaiHangRepo.getAll()) {
//							foodCategoryComboBoxModel.addElement(loaihang);
//						}
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//        		
//        		loaiHang selectCategory = (loaiHang) cboCategory.getSelectedItem();
//        		String name = txtName.getText(), unitPrice = txtUnitPrice.getText(),
//        				urlImage = txtUrlImage.getText();
//        		if (name.isEmpty() || unitPrice.isEmpty() || selectCategory == null) {
//        			JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
//        		}
//        		foodItem.setTenHangHoa(name);
//        		foodItem.setGiaHangHoa(Integer.parseInt(unitPrice));
//        		foodItem.setAnhHangHoa(urlImage);
//        		foodItem.setIdmaloaihang(selectCategory.getMaLoaiang());
//        	}
//        });
		btnCancel = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		txtName = new javax.swing.JTextField();
		txtUnitPrice = new javax.swing.JTextField();
		cboCategory = new javax.swing.JComboBox<>();
		lbPreviewImage = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jPanel1.setPreferredSize(new java.awt.Dimension(500, 50));
		jPanel1.setLayout(new java.awt.GridBagLayout());

		lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		lbTitle.setText("Thêm món ăn");
		jPanel1.add(lbTitle, new java.awt.GridBagConstraints());

		getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

		jPanel2.setPreferredSize(new java.awt.Dimension(300, 50));
		jPanel2.setLayout(new java.awt.GridBagLayout());

		btnOK.setText("Thêm");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 0.1;
		jPanel2.add(btnOK, gridBagConstraints);

		btnCancel.setText("Hủy");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 0.1;
		jPanel2.add(btnCancel, gridBagConstraints);

		getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

		jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5));
		GridBagLayout gbl_jPanel3 = new GridBagLayout();
		gbl_jPanel3.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		jPanel3.setLayout(gbl_jPanel3);

		jLabel2.setText("Tên món:");
		gridBagConstraints_1 = new java.awt.GridBagConstraints();
		gridBagConstraints_1.gridx = 0;
		gridBagConstraints_1.gridy = 0;
		gridBagConstraints_1.fill = java.awt.GridBagConstraints.VERTICAL;
		gridBagConstraints_1.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints_1.insets = new java.awt.Insets(5, 5, 5, 5);
		jPanel3.add(jLabel2, gridBagConstraints_1);
		
		lblNewLabel = new JLabel("Số lượng:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		jPanel3.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_soluong = new JTextField();
		GridBagConstraints gbc_textField_soluong = new GridBagConstraints();
		gbc_textField_soluong.gridwidth = 2;
		gbc_textField_soluong.insets = new Insets(0, 0, 5, 5);
		gbc_textField_soluong.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_soluong.gridx = 1;
		gbc_textField_soluong.gridy = 1;
		jPanel3.add(textField_soluong, gbc_textField_soluong);
		jLabel4 = new javax.swing.JLabel();

		jLabel4.setText("Hình ảnh:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		jPanel3.add(jLabel4, gridBagConstraints);

		btnChooseImage = new javax.swing.JButton();
		btnChooseImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnChooseImage.setText("Chọn Ảnh");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 0.01;
		gridBagConstraints.insets = new Insets(5, 0, 5, 5);
		jPanel3.add(btnChooseImage, gridBagConstraints);

		jLabel6.setText("Giá:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 10;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		jPanel3.add(jLabel6, gridBagConstraints);

		jLabel7.setText("Loại món:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 11;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new Insets(5, 5, 0, 5);
		jPanel3.add(jLabel7, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 0.1;
		gridBagConstraints.insets = new Insets(5, 5, 5, 0);
		jPanel3.add(txtName, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 10;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 0.1;
		gridBagConstraints.insets = new Insets(5, 5, 5, 0);
		jPanel3.add(txtUnitPrice, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 11;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 0.1;
		gridBagConstraints.insets = new Insets(5, 5, 0, 5);
		jPanel3.add(cboCategory, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 6;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
		gridBagConstraints.weightx = 0.1;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		jPanel3.add(lbPreviewImage, gridBagConstraints);

		getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

		pack();
	}

	public File file;
	private javax.swing.JButton btnCancel;
	private javax.swing.JButton btnChooseImage;
	private javax.swing.JButton btnOK;
	private javax.swing.JComboBox<loaiHang> cboCategory;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JLabel lbPreviewImage;
	private javax.swing.JLabel lbTitle;
	private javax.swing.JTextField txtName;
	private javax.swing.JTextField txtUnitPrice;
	private GridBagConstraints gridBagConstraints_1;
	private JLabel lblNewLabel;
	public javax.swing.JTextField textField_soluong;
}
