package name.martingeisse.plateui.core;

import java.awt.*;

public abstract class Widget {

    public int x, y, width, height;

    protected final void setLayout(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Subclasses will typically override this method and first call the super (this) implementation, then adjust
     * the layout according to their own behavior. A subclass which doesn't override this method will just fill all
     * available space.
     */
    public abstract void updateLayout(int x, int y, int width, int height);

    public abstract void draw(Graphics g);
}
