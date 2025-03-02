package app.views.components;

import java.awt.Dimension;

import app.models.UI;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class Form extends JPanel {
    public Form() {
        super();
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(
            400,
            (int)UI.SCREEN_SIZE.getHeight()
        ));
        setLayout(new BorderLayout());
        setBackground(UI.Colors.BACKGROUND_COLOR);

        InputField inputField = new InputField("Search a movie...", 20, 20);
        Margin pd = new Margin(0, 20);

        // add components
        pd.add(inputField);
        add(pd, BorderLayout.NORTH);
    }
}
