package name.martingeisse.plateui.core;

public abstract class Widget {

    private int x, y, width, height;

    public final void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public final void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public final int getX() {
        return x;
    }

    public final void setX(int x) {
        this.x = x;
    }

    public final int getY() {
        return y;
    }

    public final void setY(int y) {
        this.y = y;
    }

    public final int getWidth() {
        return width;
    }

    public final void setWidth(int width) {
        this.width = width;
    }

    public final int getHeight() {
        return height;
    }

    public final void setHeight(int height) {
        this.height = height;
    }

    /**
     * Should set the width and height of this widget, call layout() on all children,
     * and set the position of all children. Should NOT set the position of this widget
     * itself, because that is done by its parent.
     */
    public abstract void layout(int availableWidth, int availableHeight);

    public abstract void draw(WidgetDrawContext context);
}
