package com.henriquefuchs.snake.core;

import com.henriquefuchs.snake.graphics.Rect;
import com.henriquefuchs.snake.graphics.Renderer;
import com.henriquefuchs.snake.scene.Background;
import com.henriquefuchs.snake.scene.Food;
import com.henriquefuchs.snake.scene.GameOverText;
import com.henriquefuchs.snake.scene.Snake;
import com.henriquefuchs.snake.util.Constants;
import com.henriquefuchs.snake.util.GameUtils;

import java.awt.*;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private Snake snake;
    private Renderer renderer;
    private Food food;

    public void start() {
        this.snake = new Snake();
        this.gameWindow = new GameWindow(this.snake);
        this.food = new Food(this.gameWindow.getDrawingArea(), snake);
        this.renderer = this.gameWindow.getRenderer();
        addElementsToScreen();

        new Thread(this).start();
    }

    private void addElementsToScreen() {
        this.renderer.add(new Background());
        this.renderer.add(this.snake);
        this.renderer.add(this.food);
    }

    @Override
    public void run() {
        while (!isGameOver()) {
            this.snake.move();
            food.checkIfEaten(this.snake, this.gameWindow.getDrawingArea());
            this.gameWindow.repaint();
            GameUtils.sleep(Constants.SLEEP_TIME);
        }

        processGameOver();
    }

    private void processGameOver() {
        this.renderer.remove(snake);
        this.renderer.remove(food);
        renderer.add(new GameOverText(food.getEatenTimes()));
        gameWindow.repaint();
    }

    private boolean isGameOver() {
        return snake.collidesWithItself() || isSnakeHitBounds();
    }

    private boolean isSnakeHitBounds() {
        Rect head = snake.getFirstRect();
        Rectangle drawingArea = gameWindow.getDrawingArea();

        int headX = (int) head.getLocation().getX();
        int headY = (int) head.getLocation().getY();

        int areaX1 = (int) drawingArea.getMinX();
        int areaY1 = (int) drawingArea.getMinY() - Constants.SNAKE_PIECE_SIZE * 2;

        int areaX2 = (int) drawingArea.getMaxX();
        int areaY2 = (int) drawingArea.getMaxY();

        if (headX <= areaX1 || headX + Constants.SNAKE_PIECE_SIZE >= areaX2) {
            return true;
        }

        if (headY <= areaY1 || headY + Constants.SNAKE_PIECE_SIZE >= areaY2) {
            return true;
        }

        return false;
    }
}
