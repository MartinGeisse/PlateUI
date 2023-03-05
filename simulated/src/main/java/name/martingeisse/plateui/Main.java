package name.martingeisse.plateui;

import name.martingeisse.plateui.core.PlateWindow;
import name.martingeisse.plateui.base_library.*;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        PlateWindow window = new PlateWindow();
        // window.setGui(new Border(Color.RED, 2, new StrongSizer(50, 100, new Unicolor(Color.CYAN))));
        // window.setGui(new Border(3, Border.Style.SUNKEN, Color.RED, new Unicolor(Color.CYAN)));
        window.setGui(
            new OnionLayout(
                new Unicolor(Color.CYAN),
                new OnionLayout.Element(OnionLayout.Side.RIGHT, new WeakSizer(10, 10, new Unicolor(Color.RED)))
            )
        );
    }
}
