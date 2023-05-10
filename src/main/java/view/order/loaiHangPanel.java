package view.order;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.loaiHang;
import models.FoodCategory;
import utils.RandomColor;

public class loaiHangPanel extends javax.swing.JPanel  {
	loaiHang foodCategory;
	    public loaiHangPanel(loaiHang fc) {
	        this.foodCategory = fc;
	        initComponents();
	        lbName.setText(fc.getTenLoaiHang());
	        Color bg = RandomColor.getColor();
	        Color bgText = RandomColor.getContrastColor(bg);
	        setBackground(bg);
	        lbName.setForeground(bgText);
	    }

	    public loaiHang getFoodCategory() {
	        return foodCategory;
	    }
	    private void initComponents() {
	        java.awt.GridBagConstraints gridBagConstraints;
	        lbName = new javax.swing.JLabel();

	        setBackground(new java.awt.Color(255, 204, 204));
	        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	        setMaximumSize(new java.awt.Dimension(150, 50));
	        setPreferredSize(new java.awt.Dimension(150, 50));
	        setLayout(new java.awt.GridBagLayout());

	        lbName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
	        lbName.setForeground(new java.awt.Color(51, 0, 0));
	        lbName.setText("Topping");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 0;
	        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
	        add(lbName, gridBagConstraints);
	    }
	    private javax.swing.JLabel lbName;

}
