package app.views.components;
import app.models.UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TitleBar extends JPanel {

    private JButton minimizeButton, closeButton, maximizeButton;
    final private JFrame frame;
    private JLabel appName;

    private boolean isMaximized = true;
    private Dimension previousSize;  
    private Point previousLocation;  
    private Point initialClick;

    
    public TitleBar(JFrame frame) {
        super();
        this.previousLocation = new Point(0, 0);
        this.previousSize = new Dimension(250, 250);
        this.frame = frame;
        init();
    }

    @SuppressWarnings("unused")
    private void init() {
        setPreferredSize(new Dimension((int)UI.screenSize.getWidth(), UI.TITLE_BAR_HEIGHT));

        setBackground(UI.Colors.SECONDARY_COLOR);
        setLayout(new BorderLayout());

        appName = new JLabel("Movies Browser", SwingConstants.CENTER);
        appName.setFont(UI.Fonts.LATO_BOLD_ITALIC.deriveFont(Font.PLAIN, 18));
        appName.setForeground(UI.Colors.TEXT_COLOR);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonsPanel.setOpaque(false);

        minimizeButton = initButton(Color.GRAY, "—");
        minimizeButton.addActionListener((ActionEvent e) -> {
            frame.setExtendedState(JFrame.ICONIFIED);
        });
        
        maximizeButton = initButton(Color.GRAY, "□");
        maximizeButton.addActionListener(e -> toggleMaximize());

        closeButton = initButton(UI.Colors.DANGER, "X");
        closeButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        enableDragging();

        buttonsPanel.add(minimizeButton);
        buttonsPanel.add(maximizeButton);
        buttonsPanel.add(closeButton);

        add(appName, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.EAST);
    }

    private JButton initButton(Color hoverColor, String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setForeground(UI.Colors.TEXT_COLOR);
        button.setBackground(UI.Colors.SECONDARY_COLOR);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }
    
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(UI.Colors.SECONDARY_COLOR);
            }
        });

        button.setPreferredSize(new Dimension(50, UI.TITLE_BAR_HEIGHT));

        return button;
    }

    private void toggleMaximize() {
        if (isMaximized) {
            // Restore to previous size & location
            frame.setExtendedState(JFrame.NORMAL);
            frame.setSize(previousSize);
            frame.setLocation(previousLocation);
            maximizeButton.setText("□");
        } else {
            // Store current size & location before maximizing
            previousSize = frame.getSize();
            previousLocation = frame.getLocation();

            // Maximize the window
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            maximizeButton.setText("❐");
        }
        isMaximized = !isMaximized;
    }

    

    private void enableDragging() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (frame.getExtendedState() == JFrame.NORMAL) {
                    initialClick = e.getPoint();
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (frame.getExtendedState() == JFrame.NORMAL) {
                    int thisX = frame.getLocation().x;
                    int thisY = frame.getLocation().y;

                    int xMoved = e.getX() - initialClick.x;
                    int yMoved = e.getY() - initialClick.y;

                    int newX = thisX + xMoved;
                    int newY = thisY + yMoved;

                    frame.setLocation(newX, newY);
                }
            }
        });
    }
}
