package component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.*;


public class MonTableau extends JTable {
	
	public MonTableau() {
		super();
		this.setBackground(new Color(0xF0F0F0));
		this.setForeground(Color.BLACK);
		this.setGridColor(Color.BLACK);
		this.getTableHeader().setBackground(new Color(0x5294E2));
		this.getTableHeader().setForeground(Color.WHITE);
		this.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
		this.setRowHeight(25);
		this.setSelectionBackground(new Color(0xCCE5FF));
		
		// Remove the border of the table and its scroll pane
		this.setBorder(BorderFactory.createEmptyBorder());}
}
