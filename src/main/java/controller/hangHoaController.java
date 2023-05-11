package controller;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.hangHoa;
import model.loaiHang;
import repository.hangHoaRepository;
import repository.loaiHangHoaRepository;
import utils.ImageManager;

import view.ChooseImageView;
import view.trangChu.hangHoaView;

public class hangHoaController {

	hangHoaRepository HangHoaRepo = new hangHoaRepository();
	loaiHangHoaRepository LoaiHangRepo = new loaiHangHoaRepository();
	ChooseImageView chooseImageView = new ChooseImageView();
	ImageManager imageManager = new ImageManager();
	String resourcesPath = getClass().getResource("/images/").getPath();
	JFrame previousView;

	
	private ActionListener eventShowChooseFileDialog(hangHoaView view) {
		return evt -> {
			int otp = chooseImageView.showOpenDialog(view);
			switch (otp) {
			case JFileChooser.APPROVE_OPTION:
				File file = chooseImageView.getSelectedFile();
				BufferedImage bi;
				try {
					bi = ImageIO.read(file);
					String name = view.getTxtName().getText();
					String pth = imageManager.saveImage(bi, name);
					view.getTxtUrlImage().setText(pth);
					renderPreviewImage(view);
				} catch (Exception e) {
					view.showError(e);
				}
				break;
			case JFileChooser.CANCEL_OPTION:
				view.getTxtUrlImage().setText("");
				break;
			}
		};
	}

	private void renderPreviewImage(hangHoaView view) throws Exception {
		String urlImage = view.getTxtUrlImage().getText();
		ImageIcon icon = urlImage.isEmpty() ? null : imageManager.getImage(urlImage);
		view.getLbPreviewImage().setIcon(icon);
		view.pack();
	}

	private void initComboBox(hangHoaView view) {
		try {
			for (loaiHang loaihang : LoaiHangRepo.getAll()) {
				view.getFoodCategoryComboBoxModel().addElement(loaihang);
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
		view.getBtnChooseImage().addActionListener(eventShowChooseFileDialog(view));
		view.getBtnOK().addActionListener(evt -> {
			try {
				addFoodItem(view);
				view.dispose();
				JOptionPane.showMessageDialog(view, "Thêm món thành công");
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
		view.getLbTitle().setText("Sửa món ăn - " + foodItem.getMaHangHoa());
		view.getBtnOK().setText("Cập nhật");

//		if (foodItem == null) {
//			view
//		}
		view.getTxtName().setText(foodItem.getTenHangHoa());
		view.getTxtUrlImage().setText(foodItem.getAnhHangHoa());
		view.getTxtUnitPrice().setText(foodItem.getGiaHangHoa() + "");
		loaiHang fc = new loaiHang();
		fc.setMaLoaiang(foodItem.getIdmaloaihang());
		view.getCboCategory().setSelectedItem(fc);
		if (isExistsImage(foodItem.getAnhHangHoa())) {
			view.getTxtUrlImage().setText(foodItem.getAnhHangHoa());
		} else {
			view.getTxtUrlImage().setText("");
		}
		try {
			renderPreviewImage(view);
		} catch (Exception e) {
			e.printStackTrace();
		}
		view.getBtnChooseImage().addActionListener(eventShowChooseFileDialog(view));
		view.getBtnOK().addActionListener(evt -> {
			try {
				editFoodItem(view, foodItem);
				view.dispose();
				view.showMessage("Sửa món ăn thành công!");

			} catch (Exception ex) {

			}
		});
	}

	public boolean addFoodItem(hangHoaView view) throws Exception {
		hangHoa foodItem = new hangHoa();
		loaiHang selectCategory = (loaiHang) view.getCboCategory().getSelectedItem();
		String name = view.getTxtName().getText(), unitPrice = view.getTxtUnitPrice().getText(),
				urlImage = view.getTxtUrlImage().getText();
		if (name.isEmpty() || unitPrice.isEmpty() || selectCategory == null) {
			throw new Exception("Vui lòng điền đầy đủ thông tin");
		}
		foodItem.setTenHangHoa(name);
		foodItem.setGiaHangHoa(Integer.parseInt(unitPrice));
		foodItem.setAnhHangHoa(urlImage);
		foodItem.setIdmaloaihang(selectCategory.getMaLoaiang());
		HangHoaRepo.save(foodItem);
		return true;
	}

	public boolean editFoodItem(hangHoaView view, hangHoa foodItem) throws Exception {
		loaiHang selectCategory = (loaiHang) view.getCboCategory().getSelectedItem();
		String name = view.getTxtName().getText(), unitPrice = view.getTxtUnitPrice().getText(),
				urlImage = view.getTxtUrlImage().getText();

		if (name.isEmpty() || unitPrice.isEmpty() || selectCategory == null) {
			throw new Exception("Vui lòng điền đầy đủ thông tin");
		}
		foodItem.setTenHangHoa(name);
		foodItem.setGiaHangHoa(Integer.parseInt(unitPrice));
		foodItem.setAnhHangHoa(urlImage);
		foodItem.setIdmaloaihang(selectCategory.getMaLoaiang());
		HangHoaRepo.update(foodItem);
		return true;
	}

}
