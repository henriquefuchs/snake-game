package snake;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private Renderer renderer;

    public GameWindow() {
        renderer = new Renderer();

        setTitle(Constants.GAME_TITLE);
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        renderer.render(g);
    }

    public Renderer getRenderer() {
        return renderer;
    }
}
