package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;

public abstract class AbstractFiller extends Widget {

    @Override
    public void updateLayout(int x, int y, int width, int height) {
        setLayout(x, y, width, height);
    }

}
