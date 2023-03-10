package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;

/**
 * This sizer will suggest the preferred size to the child widget but will definitely use the preferred size for
 * its outer layout. Note that the child can still ignore the layout and use a different size, but the outer layout
 * would not respect that size.
 *
 * Pass a negative value for either size to avoid sizing along that axis.
 */
public class StrongSizer extends AbstractSizer {

    public StrongSizer(int preferredWidth, int preferredHeight, Widget child) {
        super(preferredWidth, preferredHeight, child);
    }

    @Override
    protected void adjustSizerSize(int effectivePreferredWidth, int effectivePreferredHeight) {
        setSize(effectivePreferredWidth, effectivePreferredHeight);
    }

}
