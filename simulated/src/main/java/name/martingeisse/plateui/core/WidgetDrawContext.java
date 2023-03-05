package name.martingeisse.plateui.core;

import java.awt.*;

public class WidgetDrawContext extends WidgetIterationContext {

    private final Graphics graphics;

    public WidgetDrawContext(int x, int y, int width, int height, Graphics graphics) {
        super(x, y, width, height);
        this.graphics = graphics;
    }

    public final Graphics getGraphics() {
        return graphics;
    }

    @Override
    public void enter(Widget parent, Widget child) {
        super.enter(parent, child);
        graphics.translate(child.getX(), child.getY());
    }

    @Override
    public void leave(Widget parent, Widget child) {
        super.leave(parent, child);
        graphics.translate(-child.getX(), -child.getY());
    }

    /**
     * This method is final because it is meant as a convenience method that may or may not be used. Overriding it
     * would not correctly handle the cases when a caller chooses to avoid it.
     */
    public final void drawChild(Widget parent, Widget child) {
        enter(parent, child);
        child.draw(this);
        leave(parent, child);
    }

}
