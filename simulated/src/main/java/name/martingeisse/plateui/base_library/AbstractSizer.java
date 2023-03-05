package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;
import name.martingeisse.plateui.core.WidgetDrawContext;

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

    @Override
    public void draw(WidgetDrawContext context) {
        drawChild(context);
    }

    public void layout(int availableWidth, int availableHeight) {
        int preferredWidth = getPreferredWidth();
        int effectivePreferredWidth = preferredWidth < 0 ? availableWidth : preferredWidth;
        int preferredHeight = getPreferredHeight();
        int effectivePreferredHeight = preferredHeight < 0 ? availableHeight : preferredHeight;
        getChild().layout(effectivePreferredWidth, effectivePreferredHeight);
        getChild().setPosition(0, 0);
        adjustSizerSize(effectivePreferredWidth, effectivePreferredHeight);
    }

    protected abstract void adjustSizerSize(int effectivePreferredWidth, int effectivePreferredHeight);

}
