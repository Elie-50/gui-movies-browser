package app.views.components;

import app.models.UI;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class Margin extends JPanel {
    final private int marginX, marginY;
    public Margin(int marginX, int marginY) {
        super();
        this.marginX = marginX;
        this.marginY = marginY;

        init();
    }

    private void init() {
        setLayout(new FlowLayout(FlowLayout.CENTER, marginX, marginY));
        setBackground(UI.Colors.BACKGROUND_COLOR);
    }
}
