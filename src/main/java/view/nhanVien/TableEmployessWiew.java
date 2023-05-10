package view.nhanVien;

import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.tableController;
import model.nhanVienModel;
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

public class TableEmployessWiew extends JFrame {
	
	private tableController tablecontroller;
	private table Table;
	private tableView tableview;
	
	public TableEmployessWiew() {
		this.tablecontroller = new tableController();
		this.tableview= new tableView();
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
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 10, 595, 292);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        table = new JTable();
        table.setBounds(10, 10, 575, 272);
        panel.add(table);
        
        JButton btnNewButton = new JButton("THÊM");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tablecontroller.add(tableview);
        		loadTable();
        	}
        });
        btnNewButton.setBounds(605, 77, 71, 21);
        getContentPane().add(btnNewButton);
        loadTable();
	}
	private void loadTable() {
		tableRepository tableReposity= new tableRepository();
		DefaultTableModel defaultTableModel= new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Tên bàn");
		defaultTableModel.addColumn("Trạng thái");
		try {
			for (model.table ban : tableReposity.getAll()) {
				defaultTableModel.addRow(new Object[] {
						ban.getMaBan(),
						ban.getName(),
						ban.getTrangthai(),
									});
				table.setModel(defaultTableModel);
				table.getTableHeader().setReorderingAllowed(false);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private JTable table;
}
