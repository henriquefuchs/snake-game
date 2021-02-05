package com.henriquefuchs.snake.scene;

import com.henriquefuchs.snake.graphics.Rect;
import com.henriquefuchs.snake.util.GameUtils;

import java.awt.*;

import static com.henriquefuchs.snake.util.Constants.FOOD_SIZE;
import static java.awt.Color.GREEN;

public class Food extends Rect {
    private int eatenTimes;

    public Food(Rectangle drawingArea, Snake snake) {
        setRandomLocation(drawingArea, snake);
        setDimension(new Dimension(FOOD_SIZE, FOOD_SIZE));
        setColor(GREEN);
    }

    public void setRandomLocation(Rectangle drawingArea, Snake snake) {
        do {
            int offset = 3;
            int x = GameUtils.random(
                    (int) drawingArea.getMinX() + offset,
                    (int) drawingArea.getMaxX() - offset - FOOD_SIZE);
            int y = GameUtils.random(
                    (int) drawingArea.getMinY() + offset,
                    (int) drawingArea.getMaxY() - offset - FOOD_SIZE);

            setLocation(new Point(x, y));
        } while (snake.intersects(this));
    }

    public void checkIfEaten(Snake snake, Rectangle drawingArea) {
        if (snake.intersects(this)) {
            this.eatenTimes++;
            setRandomLocation(drawingArea, snake);
            snake.elongate();
        }
    }

    public int getEatenTimes() {
        return eatenTimes;
    }
}
