package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;
import name.martingeisse.plateui.core.WidgetDrawContext;

/**
 * Wraps a single other widget.
 */
public abstract class Wrapper extends Widget {

    private final Widget child;

    public Wrapper(Widget child) {
        this.child = child;
    }

    public final Widget getChild() {
        return child;
    }

    protected void drawChild(WidgetDrawContext context) {
        context.drawChild(this, child);
    }

}
