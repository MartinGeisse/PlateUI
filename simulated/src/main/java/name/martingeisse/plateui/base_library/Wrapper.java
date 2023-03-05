package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;

import java.awt.*;

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

    // TODO: if only ever used in WeakSizer, move it there
    protected final void suggestLayoutToChildButAcceptOverride(int x, int y, int width, int height) {
        child.updateLayout(x, y, width, height);
        setLayout(x, y, child.width, child.height);
    }

    @Override
    public void draw(Graphics g) {
        child.draw(g);
    }

}
