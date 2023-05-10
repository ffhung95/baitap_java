package view.nhanVien;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.tableController;
import model.table;
import repository.tableRepository;
import view.trangChu.tableView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ListTableView extends JFrame {
	private JTable table;
	private tableController tableCon= new tableController();
	
	public ListTableView() {
		this.tableCon = new tableController();
		this.initComponents();
        this.setVisible(true);
	}

	private void initComponents() {
		setTitle("List Table");
    	this.setSize(700, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setResizable(false);
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 666, 188);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 646, 168);
        panel.add(scrollPane);
        
        table = new JTable();
        scrollPane.setColumnHeaderView(table);
        
        JButton btnNewButton = new JButton("Thêm bàn");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tableView view = new tableView();
        		tableCon.add(view);
        	}
        });
        btnNewButton.setBounds(42, 221, 132, 34);
        getContentPane().add(btnNewButton);
        
        JButton btnXaBn = new JButton("Xóa bàn");
        btnXaBn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		table ban = new table();
        		tableView view = new tableView();
        		tableCon.edit(view, ban);
        	}
        });
        btnXaBn.setBounds(296, 228, 132, 34);
        getContentPane().add(btnXaBn);
		loadTable();
	}
	private void loadTable() {
		tableRepository tableRepo = new tableRepository();
		DefaultTableModel defaultTableModel= new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Tên bàn");
		defaultTableModel.addColumn("Trạng thái");
		try {
			for (table ban : tableRepo.getAll()) {
				defaultTableModel.addRow(new Object[] {
						ban.getMaBan(),
						ban.getName(),
						ban.getTrangthai()
									});
				table.setModel(defaultTableModel);
				table.getTableHeader().setReorderingAllowed(false);	
}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
