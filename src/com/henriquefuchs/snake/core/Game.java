package com.henriquefuchs.snake.core;

import com.henriquefuchs.snake.graphics.Renderer;
import com.henriquefuchs.snake.scene.Background;
import com.henriquefuchs.snake.scene.Snake;
import com.henriquefuchs.snake.util.GameUtils;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private Snake snake;
    private Renderer renderer;

    public void start() {
        this.snake = new Snake();
        this.gameWindow = new GameWindow(this.snake);
        this.renderer = gameWindow.getRenderer();
        addElementsToScreen();

        new Thread(this).start();
    }

    private void addElementsToScreen() {
        this.renderer.add(new Background());
        this.renderer.add(this.snake);
    }

    @Override
    public void run() {
        while (!isGameOver()) {
            this.snake.move();
            this.gameWindow.repaint();
            GameUtils.sleep(30);
        }
        gameWindow.dispose();
    }

    private boolean isGameOver() {
        return snake.collidesWithItself();
    }
}
