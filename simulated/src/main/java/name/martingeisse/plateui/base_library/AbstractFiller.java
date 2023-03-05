package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;

public abstract class AbstractFiller extends Widget {

    @Override
    public void layout(int availableWidth, int availableHeight) {
        setSize(availableWidth, availableHeight);
    }

}
