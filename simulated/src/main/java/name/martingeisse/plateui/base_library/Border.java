package name.martingeisse.plateui.base_library;

import name.martingeisse.plateui.core.Widget;

import java.awt.*;

public class Border extends Wrapper {
    private final int thickness;
    private final Style style;
    private final Color color;

    public Border(int thickness, Style style, Color color, Widget child) {
        super(child);
        this.thickness = thickness;
        this.style = style;
        this.color = color;
    }

    @Override
    public void updateLayout(int x, int y, int width, int height) {
        Widget child = getChild();
        getChild().updateLayout(x + thickness, y + thickness, width - 2 * thickness, height - 2 * thickness);
        setLayout(x, y, child.width + 2 * thickness, child.height + 2 * thickness);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        for (int i = 0; i < thickness; i++) {
            g.setColor(style.getTopLeftColor(color));
            g.drawLine(x, y + i, x + width - i - 2, y + i); // top
            g.drawLine(i, y + thickness, i, y + height - i - 2); // left
            g.setColor(style.getBottomRightColor(color));
            g.drawLine(x + 1 + i, y + height - 1 - i, x + width - 1, y + height - 1 - i); // bottom
            g.drawLine(x + width - 1 - i, y + 1 + i, x + width - 1 - i, y + height - thickness - 1); // right
            g.setColor(color);
            g.drawLine(x + width - i - 1, y + i, x + width - i - 1, y + i); // top right
            g.drawLine(x + i, y + height - 1 - i, x + i, y + height - 1 - i); // bottom left
        }
    }

    public enum Style {
        SOLID {

            @Override
            public Color getTopLeftColor(Color baseColor) {
                return baseColor;
            }

            @Override
            public Color getBottomRightColor(Color baseColor) {
                return baseColor;
            }

        },
        RAISED {

            @Override
            public Color getTopLeftColor(Color baseColor) {
                return baseColor.brighter();
            }

            @Override
            public Color getBottomRightColor(Color baseColor) {
                return baseColor.darker();
            }

        },
        SUNKEN {

            @Override
            public Color getTopLeftColor(Color baseColor) {
                return baseColor.darker();
            }

            @Override
            public Color getBottomRightColor(Color baseColor) {
                return baseColor.brighter();
            }

        };

        public abstract Color getTopLeftColor(Color baseColor);
        public abstract Color getBottomRightColor(Color baseColor);
    }
}
