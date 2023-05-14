package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.table;
import repository.tableRepository;
import utils.TableStatus;
import view.trangChu.tableView;

public class tableController {
tableRepository TableRepo= new tableRepository();
JFrame previousView;
public void addTable(tableView view) throws Exception {
    String name = view.getTxtName().getText();
    if (name.isEmpty()) {
        throw new Exception("Vui lòng điền đủ thông tin");
    }
    if (TableRepo.findByName(name) != null) {
        throw new Exception("Tên bàn đã được sử dụng");
    }
    table t = new table();
    t.setName(name);
    t.setTrangthai(TableStatus.FREE);
    TableRepo.save(t);
}
public void editTable(tableView view, table t) throws Exception {
    String tableName = view.getTxtName().getText();
    if (tableName.isEmpty()) {
        throw new Exception("Điền tên bàn");
    }
    table temp = TableRepo.findByName(tableName);
    if (temp != null && temp.getMaBan() != t.getMaBan()) {
        throw new Exception("Tên bàn đã được sử dụng");
    }
    t.setName(tableName);
    TableRepo.update(t);
}
public void add(tableView view) {
    if (previousView != null && previousView.isDisplayable()) {
        previousView.requestFocus();
        return;
    }
    previousView = view;
    view.setVisible(true);
    view.getBtnCancel().addActionListener(evt -> view.dispose());
    view.getBtnOK().addActionListener(evt -> {
        try {
            addTable(view);
            view.dispose();
            view.showMessage("Thêm bàn thành công!");
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    });

}
public void edit(tableView view, table Table) {
    if (previousView != null && previousView.isDisplayable()) {
        previousView.requestFocus();
        return;
    }
    previousView = view;
    view.setVisible(true);
    view.getBtnCancel().addActionListener(evt -> view.dispose());
    view.getLbTitle().setText("Sửa bàn - " + Table.getMaBan());
    view.getTxtName().setText(Table.getName());
    view.getBtnOK().setText("Cập nhật");
    view.getBtnOK().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                editTable(view, Table);
                view.dispose();
                view.showMessage("Sửa bàn thành công!");
            } catch (Exception ex) {
            }
        }
    });

}
}
