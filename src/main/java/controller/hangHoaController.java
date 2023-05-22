package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Admin;
import model.hangHoa;
import model.loaiHang;
import repository.AdminReposity;
import repository.hangHoaRepository;
import repository.loaiHangHoaRepository;

import view.ChooseImageView;
import view.trangChu.hangHoaView;

public class hangHoaController {
	public File file;
	hangHoaRepository HangHoaRepo = new hangHoaRepository();
	AdminReposity adminrepository = new AdminReposity();
	loaiHangHoaRepository LoaiHangRepo = new loaiHangHoaRepository();
	ChooseImageView chooseImageView = new ChooseImageView();

	String resourcesPath = getClass().getResource("/images/").getPath();
	JFrame previousView;


	private void initComboBox(hangHoaView view) {
		try {
			for (loaiHang loaihang : LoaiHangRepo.getAll()) {
				view.getFoodCategoryComboBoxModel().addElement(loaihang);
			}
			for(Admin ADMIN :adminrepository.getAdmin()) {
				view.getAdminComboBoxModel().addElement(ADMIN);
			}
		} catch (Exception e) {
		}
	}

	public void add(hangHoaView view) {
		if (previousView != null && previousView.isDisplayable()) {
			previousView.requestFocus();
			return;
		}
		previousView = view;
		view.setVisible(true);
		view.getBtnCancel().addActionListener(evt -> view.dispose());
		initComboBox(view);

		view.getBtnChooseImage().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfilechoooser = new JFileChooser();
				jfilechoooser.setMultiSelectionEnabled(false);
				if (jfilechoooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					file = jfilechoooser.getSelectedFile();
				}
			}
		});

		view.getBtnOK().addActionListener(evt -> {
			try {
				addFoodItem(view);
				view.dispose();
				JOptionPane.showMessageDialog(view, "ThÃªm mÃ³n thÃ nh cÃ´ng");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

	public boolean isExistsImage(String imagePath) {
		try {
			if (imagePath.isEmpty()) {
				return false;
			}
			File f = new File(resourcesPath + imagePath);
			return f.exists() && !f.isDirectory();
		} catch (Exception e) {
			return false;
		}
	}

	public void edit(hangHoaView view, hangHoa foodItem) {
		if (previousView != null && previousView.isDisplayable()) {
			previousView.requestFocus();
			return;
		}
		previousView = view;
		view.setVisible(true);
		view.getBtnCancel().addActionListener(evt -> view.dispose());
		initComboBox(view);
		view.getLbTitle().setText("SÃ¡Â»Â­a mÃƒÂ³n Ã„Æ’n - " + foodItem.getMaHangHoa());
		view.getBtnOK().setText("CÃ¡ÂºÂ­p nhÃ¡ÂºÂ­t");

//		if (foodItem == null) {
//			view
//		}
		view.getTxtName().setText(foodItem.getTenHangHoa());

		view.getTxtUnitPrice().setText(foodItem.getGiaHangHoa() + "");
		loaiHang fc = new loaiHang();
		fc.setMaloaihang(foodItem.getMaloaihang());
		view.getCboCategory().setSelectedItem(fc);

		try {
//			renderPreviewImage(view);
		} catch (Exception e) {
			e.printStackTrace();
		}
		view.getBtnChooseImage().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfilechoooser = new JFileChooser();
				jfilechoooser.setMultiSelectionEnabled(false);
				if (jfilechoooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					file = jfilechoooser.getSelectedFile();
				}
			}
		});
		view.getBtnOK().addActionListener(evt -> {
			try {
				editFoodItem(view, foodItem);
				view.dispose();
				view.showMessage("SÃ¡Â»Â­a mÃƒÂ³n Ã„Æ’n thÃƒÂ nh cÃƒÂ´ng!");

			} catch (Exception ex) {

			}
		});
	}

	public boolean addFoodItem(hangHoaView view) throws Exception {
		hangHoa foodItem = new hangHoa();
		int soluong = Integer.valueOf(view.getTxtSoLuong().getText());
		loaiHang selectCategory = (loaiHang) view.getCboCategory().getSelectedItem();
		Admin selectAdmin = (Admin) view.getComboBox_tenquanli().getSelectedItem();
		String name = view.getTxtName().getText(), unitPrice = view.getTxtUnitPrice().getText();
		if (name.isEmpty() || unitPrice.isEmpty() || selectCategory == null) {
			throw new Exception("Vui lÃƒÂ²ng Ã„â€˜iÃ¡Â»Ân Ã„â€˜Ã¡ÂºÂ§y Ã„â€˜Ã¡Â»Â§ thÃƒÂ´ng tin");
		}
		if (soluong >= 0) {
			foodItem.setTenHangHoa(name);
			foodItem.setSoLuong(soluong);
			foodItem.setGiaHangHoa(Integer.parseInt(unitPrice));
			foodItem.setAnhHangHoa(Files.readAllBytes(file.toPath()));
			foodItem.setMaloaihang(selectCategory.getMaloaihang());
			foodItem.setIdAdmin(selectAdmin.getMaadmin());
			HangHoaRepo.save(foodItem);
		} else {
			view.showMessage("KiÃ¡Â»Æ’m tra sÃ¡Â»â€˜ lÃ†Â°Ã¡Â»Â£ng sÃ¡ÂºÂ£n phÃ¡ÂºÂ©m");
		}

		return true;
	}

	public boolean editFoodItem(hangHoaView view, hangHoa foodItem) throws Exception {
		loaiHang selectCategory = (loaiHang) view.getCboCategory().getSelectedItem();
		String name = view.getTxtName().getText(), unitPrice = view.getTxtUnitPrice().getText();
		Admin selectAdmin = (Admin) view.getComboBox_tenquanli().getSelectedItem();
		if (name.isEmpty() || unitPrice.isEmpty() || selectCategory == null) {
			throw new Exception("Vui lÃƒÂ²ng Ã„â€˜iÃ¡Â»Ân Ã„â€˜Ã¡ÂºÂ§y Ã„â€˜Ã¡Â»Â§ thÃƒÂ´ng tin");
		}
		foodItem.setTenHangHoa(name);
		foodItem.setGiaHangHoa(Integer.parseInt(unitPrice));
		foodItem.setAnhHangHoa(Files.readAllBytes(file.toPath()));
		foodItem.setMaloaihang(selectCategory.getMaloaihang());
		foodItem.setIdAdmin(selectAdmin.getMaadmin());
		HangHoaRepo.update(foodItem);
		return true;
	}

}
