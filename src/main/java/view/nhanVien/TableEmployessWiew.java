package view.nhanVien;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controller.tableController;
import repository.NhanVienReposity;
import repository.tableRepository;
import model.*;
import view.trangChu.tableView;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class TableEmployessWiew extends JFrame {
	
	private tableController tablecontroller;
	private tableView view;
	private table tableModel;
	private JTable tableView;
	private tableRepository tablerepository;
	
	public TableEmployessWiew() {
		this.tablecontroller = new tableController();
		this.tablerepository= new tableRepository();
		this.tableModel = new table();
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 666, 177);
		getContentPane().add(scrollPane);
		
		tableView = new JTable();
		scrollPane.setColumnHeaderView(tableView);
		
		JButton btnNewButton = new JButton("Thêm ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view = new tableView();
				view.setVisible(true);
			}
		});
		btnNewButton.setBounds(20, 197, 85, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table tableDelete = new table();
				tableDelete.setMaBan(getMaban());
				try {
					tablerepository.delete(tableDelete);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
					dispose();
					loadTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(159, 197, 85, 21);
		getContentPane().add(btnNewButton_1);
		this.init();
		this.setVisible(true);
	}

	private void init() {
		setTitle("Table");
    	this.setSize(700, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setResizable(false);
        loadTable();
	}
	private void loadTable() {
		tableRepository tableReposity= new tableRepository();
		DefaultTableModel defaultTableModel= new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Tên bàn");
		defaultTableModel.addColumn("Trạng thái");
		try {
			for (table ban : tableReposity.getAll()) {
				defaultTableModel.addRow(new Object[] {
						ban.getMaBan(),
						ban.getName(),
						ban.getTrangthai(),
									});
				tableView.setModel(defaultTableModel);
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
