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
		this.setBounds(0, 0, 1062, 703);
		this.init();
		this.setLayout(null);
		this.setVisible(true);
	}
	private void init() {
		Table_Panel_All= new JPanel();
		Table_Panel_All.setLayout(null);
		Table_Panel_All.setBounds(0,0, 1062,  703);
		
		JPanel ptableview= new JPanel();
		ptableview.setBounds(30,  100,  1000,  500);
		tableView= new JTable();
		tableView.setPreferredSize(new Dimension(1000, 500));
		tableView.setModel(new DefaultTableModel(
	        	new Object[][] {
	        	},
	        	new String[] {
	        		"Id", "Tên bàn", "Trạng Thái"
	        	}
	        ));
		JScrollPane scrtable= new JScrollPane(tableView);
		ptableview.add(scrtable);
		Table_Panel_All.add(ptableview);
		this.add(Table_Panel_All);
        loadTable();
	}
	private void loadTable() {
		tableRepository tableReposity= new tableRepository();
		DefaultTableModel defaultTableModel= new DefaultTableModel();
//		defaultTableModel.addColumn("ID");
//		defaultTableModel.addColumn("Tên bàn");
//		defaultTableModel.addColumn("Trạng thái");
//		tableView.setModel(defaultTableModel);
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
