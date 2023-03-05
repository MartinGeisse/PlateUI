package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;

/**
 * This sizer will suggest the preferred size to the child widget but then accept any size actually used by the child
 * for its outer layout.
 *
 * Pass a negative value for either size to avoid sizing along that axis.
 */
public class WeakSizer extends AbstractSizer {

    public WeakSizer(int preferredWidth, int preferredHeight, Widget child) {
        super(preferredWidth, preferredHeight, child);
    }

    @Override
    public void updateLayout(int x, int y, int width, int height) {
        suggestLayoutToChildButAcceptOverride(x, y, getPreferredWidth(), getPreferredHeight());
    }

}
