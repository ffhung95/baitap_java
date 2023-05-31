package view.nhanVien;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controller.tableController;
import repository.NhanVienReposity;
import repository.tableRepository;
import model.*;
import view.admin.trangChuAdmin;
import view.trangChu.tableView;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.formula.functions.Mode;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class TableEmployessWiew extends JPanel {
	
	private tableController tablecontroller;
	private tableView view;
	private table tableModel;
	private JTable tableView;
	private tableRepository tablerepository;
	private JPanel Table_Panel_All;
	public TableEmployessWiew() {
		this.setSize(1062, 703);
//		this.tablecontroller = new tableController();
//		this.tablerepository= new tableRepository();
//		this.tableModel = new table();
		this.setLayout(null);
		Table_Panel_All= new JPanel();
		Table_Panel_All.setBounds(0,  0,  1062,  703);
		tableView = new JTable();
		tableView.setPreferredSize(new Dimension(1062, 500));
		
		JPanel TBSCR= new JPanel();
		TBSCR.setBounds(0,  0,  1062,  503);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setColumnHeaderView(tableView);
		TBSCR.add(scrollPane);
		Table_Panel_All.add(TBSCR);
		JButton btnNewButton = new JButton("Thêm ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view = new tableView();
				view.setVisible(true);
			}
		});
		btnNewButton.setBounds(20, 197, 85, 21);
		//getContentPane().add(btnNewButton);
		Table_Panel_All.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table tableDelete = new table();
				tableDelete.setMaBan(getMaban());
				try {
					tablerepository.delete(tableDelete);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
					loadTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(159, 197, 85, 21);
		//getContentPane().add(btnNewButton_1);
		Table_Panel_All.add(btnNewButton_1);
		this.init();
		this.setVisible(true);
	}

	private void init() {
//		setTitle("Table");
//    	this.setSize(700, 360);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setLocationRelativeTo(null);
//        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
//        this.setResizable(false);
		this.setSize(1062, 703);
		this.add(Table_Panel_All);
        loadTable();
	}
	private void loadTable() {
		tableRepository tableReposity= new tableRepository();
		DefaultTableModel defaultTableModel= new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Tên bàn");
		defaultTableModel.addColumn("Trạng thái");
		tableView.setModel(defaultTableModel);
		try {
			for (table ban : tableReposity.getAll()) {
				defaultTableModel.addRow(new Object[] {
						ban.getMaBan(),
						ban.getName(),
						ban.getTrangthai(),
									});
				
				tableView.getTableHeader().setReorderingAllowed(false);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private int getMaban() {
		DefaultTableModel model_table = (DefaultTableModel) tableView.getModel();
		int i_row = tableView.getSelectedRow();
		int maban = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		return maban;
	}
}
