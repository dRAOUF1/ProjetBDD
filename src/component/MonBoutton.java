package component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
public class MonBoutton extends JButton {

	    private static final long serialVersionUID = 1L;

	    public MonBoutton(String text) {
	        super(text);
	        setOpaque(false);
	        setForeground(Color.WHITE);
	        setFont(new Font("Helvetica", Font.PLAIN, 12));
	        setContentAreaFilled(false);
	        setBorderPainted(false);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.setColor(new Color(0x5294E2));
	        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
	        g2.setColor(Color.WHITE);
	        g2.setFont(getFont());
	        g2.drawString(getText(), getWidth() / 2 - g2.getFontMetrics().stringWidth(getText()) / 2,
	                getHeight() / 2 + g2.getFontMetrics().getAscent() / 3);
	        g2.dispose();
	    }

	}

