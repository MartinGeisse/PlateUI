package name.martingeisse.plateui.base_library;

import java.awt.*;

public final class Unicolor extends AbstractFiller {

    public final Color color;

    public Unicolor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

}
