package app.views.components;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import app.models.UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;

public class InputField extends JTextField {

    private String placeholder;
    private int radius;

    public InputField() {
        super();
        init();
    }

    public InputField(String placeholder) {
        super(placeholder);
        this.placeholder = placeholder;
        this.radius = 0;
        init();
    }

    public InputField(String placeholder, int columns) {
        super(placeholder, columns);
        this.placeholder = placeholder;
        this.radius = 0;
        init();
    }

    public InputField(String placeholder, int columns, int radius) {
        super(placeholder, columns);
        this.placeholder = placeholder;
        this.radius = radius;

        init();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        ((Graphics2D) g).drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }

    private void init() {
        
        setForeground(UI.Colors.PLACEHOLDER);
        setBackground(UI.Colors.SECONDARY_COLOR);
        setBorder(BorderFactory.createEmptyBorder());
        setMargin(new Insets(20, 20, 20, 0));
        setPreferredSize(new Dimension(400, 30));
        Font font = UI.Fonts.LATO_REGULAR.deriveFont(Font.PLAIN, 18);
        setFont(font);

        addFocusListener(new FocusListener() {
            String value = getText().toLowerCase().trim();
            @Override
            public void focusGained(FocusEvent e) {
                if(value.equals(placeholder.toLowerCase())) {
                    setText("");
                    setForeground(UI.Colors.TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (value.isEmpty()) {
                    setText(placeholder);
                    setForeground(UI.Colors.PLACEHOLDER);
                }
            } 
            
        });
    }

}
