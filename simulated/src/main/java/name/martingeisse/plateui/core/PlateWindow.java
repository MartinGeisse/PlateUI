package name.martingeisse.plateui.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlateWindow extends JFrame {

    public static final int WIDTH = 200;
    public static final int HEIGHT = 200;

    public final JPanel panel;
    private Widget gui;

    public PlateWindow() throws HeadlessException {
        super("PlateUI");

        panel = new JPanel(false) {
            @Override
            protected void paintComponent(Graphics g) {
                if (gui != null) {
                    gui.draw(g);
                }
            }
        };
        panel.setFocusable(true);
        panel.setSize(WIDTH, HEIGHT);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        add(panel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void setGui(Widget gui) {
        this.gui = gui;
        gui.updateLayout(0, 0, WIDTH, HEIGHT);
        repaint();
    }

}
