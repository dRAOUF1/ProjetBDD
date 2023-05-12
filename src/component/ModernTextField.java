package component;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ModernTextField extends JTextField {
    
    public ModernTextField() {
        super();
        setPreferredSize(new Dimension(200, 30));
        setFont(new Font("Arial", Font.PLAIN, 12));
        Border line = BorderFactory.createLineBorder(Color.GRAY, 1);
        Border empty = BorderFactory.createEmptyBorder(0, 5, 0, 5);
        setBorder(BorderFactory.createCompoundBorder(line, empty));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setCaretColor(Color.BLACK);
    }
}
