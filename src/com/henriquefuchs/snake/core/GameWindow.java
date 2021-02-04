package com.henriquefuchs.snake.core;

import com.henriquefuchs.snake.scene.Snake;
import com.henriquefuchs.snake.util.Constants;
import com.henriquefuchs.snake.graphics.Renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame implements KeyListener {

    private Renderer renderer;
    private Snake snake;
    private Image buffer;
    private Graphics gImage;

    public GameWindow(Snake snake) {
        this.renderer = new Renderer();
        this.snake = snake;

        setTitle(Constants.GAME_TITLE);
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(this);
        setVisible(true);

        this.buffer = createImage(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.gImage = buffer.getGraphics();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            snake.up();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            snake.down();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            snake.left();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            snake.right();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void paint(Graphics gScreen) {
        renderer.render(gImage);
        gScreen.drawImage(buffer, 0, 0, null);
    }

    public Renderer getRenderer() {
        return renderer;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
