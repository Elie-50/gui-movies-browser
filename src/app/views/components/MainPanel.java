package app.views.components;

import app.models.UI;
import java.awt.Dimension;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
    public MainPanel() {
        super();
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(
            (int)UI.screenSize.getWidth(),
            (int)UI.screenSize.getWidth() - UI.TITLE_BAR_HEIGHT
        ));
        setBackground(UI.Colors.BACKGROUND_COLOR);

        // add components
        add(new InputField("Search movies...", 40, 20));

    }
}
