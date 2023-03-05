package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;
import name.martingeisse.plateui.core.WidgetDrawContext;

/**
 * Note: This layout will NOT shrink to the size required by its center component and elements, but rather fill
 * all available space, placing the elements, leaving the remaining space for the center component, even if the
 * center component doesn't use all that space. An option to shrink the layout to the actually required size might
 * be added in the future. (Implementation hint: perform updateLayout just like now, but at the end, resize the
 * and move the elements and finally this layout. However, doing so will break an element that changes the
 * orthogonal size due to this resize (e.g. text flow), and we cannot handle that further in a simple way without going
 * into an infinite loop. This should just be mentioned as a limitation of that option.)
 */
public final class OnionLayout extends Widget {
    private final Widget center;
    private final Element[] elements;

    public OnionLayout(Widget center, Element... elements) {
        this.center = center;
        this.elements = elements;
    }

    @Override
    public void layout(int availableWidth, int availableHeight) {
        setSize(availableWidth, availableHeight);

        int x = 0, y = 0, width = availableWidth, height = availableHeight;
        for (Element element : elements) {
            element.widget.layout(width, height);
            switch (element.side) {
                case LEFT -> {
                    element.widget.setPosition(x, y);
                    x += element.widget.getWidth();
                }
                case TOP -> {
                    element.widget.setPosition(x, y);
                    y += element.widget.getHeight();
                }
                case RIGHT -> {
                    width -= element.widget.getWidth();
                    element.widget.setPosition(x + width, y);
                }
                case BOTTOM -> {
                    height -= element.widget.getHeight();
                    element.widget.setPosition(x, y + height);
                }
            }
        }
        center.layout(width, height);
        center.setPosition(x, y);
    }

    @Override
    public void draw(WidgetDrawContext context) {
        context.drawChild(this, center);
        for (Element element : elements) {
            context.drawChild(this, element.widget);
        }
    }

    public record Element(Side side, Widget widget) {}

    public enum Side {
        TOP, BOTTOM, LEFT, RIGHT
    }
}
