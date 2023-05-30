package component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class MaComboBox extends JComboBox<String> {

    public MaComboBox() {
        super();
        this.setMaximumSize(new Dimension(1500, 17));
        setUI(new BasicComboBoxUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                UIManager.put("ComboBox.background", Color.WHITE);
                UIManager.put("ComboBox.foreground", Color.BLACK);
                UIManager.put("ComboBox.selectionBackground", new Color(0x5294E2));
                UIManager.put("ComboBox.selectionForeground", Color.WHITE);
                UIManager.put("ComboBox.border", BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.BLACK), 
                        BorderFactory.createEmptyBorder(2, 5, 2, 5)));
                UIManager.put("ComboBox.font", new Font("Arial", Font.PLAIN, 12));
            }
        });

        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setForeground(Color.BLACK);
                setBackground(Color.WHITE);
                setFont(new Font("Arial", Font.PLAIN, 12));
                if (isSelected) {
                    setBackground(new Color(0x5294E2));
                    setForeground(Color.WHITE);
                }
                setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                return this;
            }
        });
    }
}
