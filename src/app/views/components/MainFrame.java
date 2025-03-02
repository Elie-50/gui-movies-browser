package app.views.components;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements MouseMotionListener, MouseListener {
    public static MainPanel mainPanel;
    private static TitleBar titleBar;
    
    final private int BORDER_THICKNESS = 10;

    private boolean resizingX = false;
    private boolean resizingY = false;

    // private String currentPage = "Main";

    public MainFrame() {
        super();
        init();
    }

    private void init() {
        titleBar = new TitleBar(this);
        mainPanel = new MainPanel();

        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        addMouseMotionListener(this);
        addMouseListener(this);
        
        add(titleBar, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (resizingX || resizingY) {
            int newWidth = resizingX ? e.getX() : getWidth();
            int newHeight = resizingY ? e.getY() : getHeight();
            setSize(newWidth, newHeight);
        }
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int width = getWidth();
        int height = getHeight();

        if (x >= width - BORDER_THICKNESS && y >= height - BORDER_THICKNESS) {
            setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
        } else if (x >= width - BORDER_THICKNESS) {
            setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
        } else if (y >= height - BORDER_THICKNESS) {
            setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
        } else {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int width = getWidth();
        int height = getHeight();

        resizingX = x >= width - BORDER_THICKNESS;
        resizingY = y >= height - BORDER_THICKNESS;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        resizingX = false;
        resizingY = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

}
