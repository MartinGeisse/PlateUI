package name.martingeisse.plateui.core;

public class WidgetIterationContext {
    private int x, y, width, height;

    public WidgetIterationContext(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void enter(Widget outerWidget, Widget innerWidget) {
        x += innerWidget.getX();
        y += innerWidget.getY();
        width = innerWidget.getWidth();
        height = innerWidget.getHeight();
    }

    public void leave(Widget outerWidget, Widget innerWidget) {
        x -= innerWidget.getX();
        y -= innerWidget.getY();
        width = outerWidget.getWidth();
        height = outerWidget.getHeight();
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final int getWidth() {
        return width;
    }

    public final int getHeight() {
        return height;
    }

}
