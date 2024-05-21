package Windows;

import java.awt.*;
import WindowOnWindow.WindowOnWindow;

public class TextboxWindow extends Panel {
    private String text;

    private int defaultWindowHeight = 128;
    private int padding = 16;
    private int characterWidth = 32;

    public TextboxWindow(String text, Point location) {
        super("");
        this.text = text;
        this.view = new View(new Dimension((padding * 2) + (text.length() * characterWidth), defaultWindowHeight), this);
        this.view.setLocation(location);
    }

    public void draw(Graphics2D graphics2D, Dimension size) {
        Font font = WindowOnWindow.getTextFont();

        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(font);

        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);

        int textWidth = fontMetrics.stringWidth(text);

        graphics2D.drawString(text, (int) ((size.getWidth() - textWidth) / 2), (int) ((size.getHeight() - (TITLE_BAR_HEIGHT / 2)) / 2) + TITLE_BAR_HEIGHT);
    }

    public int getWidth() {
        return (padding * 2) + (text.length() * characterWidth);
    }
}