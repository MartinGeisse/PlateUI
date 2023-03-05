package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;

import java.awt.*;

public final class OnionLayout extends Widget {
    private final Widget center;
    private final Element[] elements;

    public OnionLayout(Widget center, Element... elements) {
        this.center = center;
        this.elements = elements;
    }

    @Override
    public void updateLayout(int x, int y, int width, int height) {
        for (Element element : elements) {
            element.widget.updateLayout(x, y, width, height);
            switch (element.side) {
                case LEFT -> x += element.widget.width;
                case TOP -> y += element.widget.height;
                case RIGHT -> {
                    width -= element.widget.width;
                    element.widget.x = x + width;
                }
                case BOTTOM -> {
                    height -= element.widget.height;
                    element.widget.y = y + height;
                }
            }
        }
        center.updateLayout(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        center.draw(g);
        for (Element element : elements) {
            element.widget.draw(g);
        }
    }

    public record Element(Side side, Widget widget) {}

    public enum Side {
        TOP, BOTTOM, LEFT, RIGHT
    }
}
