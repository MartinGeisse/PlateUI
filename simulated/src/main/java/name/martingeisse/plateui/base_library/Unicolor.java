package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.WidgetDrawContext;

import java.awt.*;

public final class Unicolor extends AbstractFiller {

    private final Color color;

    public Unicolor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void draw(WidgetDrawContext context) {
        Graphics g = context.getGraphics();
        g.setColor(color);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

}
