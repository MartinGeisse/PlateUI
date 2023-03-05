package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;

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
    public void updateLayout(int x, int y, int width, int height) {
        Widget child = getChild();
        getChild().updateLayout(x + left, y + top, width - left - right, height - top - bottom);
        setLayout(x, y, child.width + left + right, child.height + top + bottom);
    }

}
