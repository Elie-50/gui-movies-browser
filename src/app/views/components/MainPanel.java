package app.views.components;

import app.models.UI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
    public MainPanel() {
        super();
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(
            (int)UI.SCREEN_SIZE.getWidth(),
            (int)UI.SCREEN_SIZE.getWidth() - UI.TITLE_BAR_HEIGHT
        ));
        setBackground(UI.Colors.BACKGROUND_COLOR);
        setLayout(new BorderLayout());

        // Form side
        Form form = new Form();
        

        add(form, BorderLayout.WEST);

    }
}
