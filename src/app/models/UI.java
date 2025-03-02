package app.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

public class UI {

    final private static String LATO_DIR = System.getProperty("user.dir") + "/assets/fonts/lato/";

    private static Font generateFonts(String path_to_font) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path_to_font));
            // font = font.deriveFont(Font.PLAIN, 24);

            return font;
        } catch (IOException | FontFormatException e) {
            System.err.println("Font error: " + e.getMessage());
            return null;
        }
    }

    public class Colors {
        final public static Color BACKGROUND_COLOR = new Color(36, 41, 61);
        final public static Color TEXT_COLOR = new Color(244, 244, 252);
        final public static Color ACCENT_COLOR = new Color(142, 187, 255);
        final public static Color SECONDARY_COLOR = new Color(47, 56, 85);
        final public static Color DANGER = new Color(187, 33, 36);
        final public static Color PLACEHOLDER = new Color(252, 252, 255);
    }

    public class Fonts {
        final public static Font LATO_BLACK = generateFonts(LATO_DIR + "Lato-Black.ttf");
        final public static Font LATO_BLACK_ITALIC = generateFonts(LATO_DIR + "Lato-BlackItalic.ttf");
        final public static Font LATO_BOLD = generateFonts(LATO_DIR + "Lato-Bold.ttf");
        final public static Font LATO_BOLD_ITALIC = generateFonts(LATO_DIR + "Lato-BoldItalic.ttf");
        final public static Font LATO_ITALIC = generateFonts(LATO_DIR + "Lato-Italic.ttf");
        final public static Font LATO_LIGHT = generateFonts(LATO_DIR + "Lato-Light.ttf");
        final public static Font LATO_LIGHT_ITALIC = generateFonts(LATO_DIR + "Lato-LightItalic.ttf");
        final public static Font LATO_REGULAR = generateFonts(LATO_DIR + "Lato-Regular.ttf");
        final public static Font LATO_THIN = generateFonts(LATO_DIR + "Lato-Thin.ttf");
        final public static Font LATO_THIN_ITALIC = generateFonts(LATO_DIR + "Lato-ThinItalic.ttf");
    }

    final public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    final public static int TITLE_BAR_HEIGHT = 35;
    
}
