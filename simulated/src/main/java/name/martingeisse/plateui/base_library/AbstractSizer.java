package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;

/**
 * Base class of {@link StrongSizer} and {@link WeakSizer} that defines fields for the preferred size.
 */
public abstract class AbstractSizer extends Wrapper {

    private int preferredWidth;
    private int preferredHeight;

    public AbstractSizer(int preferredWidth, int preferredHeight, Widget child) {
        super(child);
        this.preferredWidth = preferredWidth;
        this.preferredHeight = preferredHeight;
    }

    public final int getPreferredWidth() {
        return preferredWidth;
    }

    public final void setPreferredWidth(int preferredWidth) {
        this.preferredWidth = preferredWidth;
    }

    public final int getPreferredHeight() {
        return preferredHeight;
    }

    public final void setPreferredHeight(int preferredHeight) {
        this.preferredHeight = preferredHeight;
    }

}
