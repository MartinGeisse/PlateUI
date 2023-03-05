package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;
import name.martingeisse.plateui.core.WidgetDrawContext;

public class Margin extends Wrapper {
    private final int top, bottom, left, right;

    public Margin(Widget child, int margin) {
        this(child, margin, margin, margin, margin);
    }

    public Margin(Widget child, int top, int bottom, int left, int right) {
        super(child);
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    @Override
    public void layout(int availableWidth, int availableHeight) {
        Widget child = getChild();
        child.layout(availableWidth - left - right, availableHeight - top - bottom);
        child.setPosition(left, top);
        setSize(child.getWidth() + left + right, child.getHeight() + top + bottom);
    }

    @Override
    public void draw(WidgetDrawContext context) {
        drawChild(context);
    }

}
