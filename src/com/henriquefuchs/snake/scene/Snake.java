package com.henriquefuchs.snake.scene;

import com.henriquefuchs.snake.core.Direction;
import com.henriquefuchs.snake.graphics.Rect;
import com.henriquefuchs.snake.graphics.Shape;
import com.henriquefuchs.snake.util.Constants;
import com.henriquefuchs.snake.util.GameUtils;

import static com.henriquefuchs.snake.util.Constants.SNAKE_ELONGATE_PIECES;

public class Snake extends Shape {
    private Direction direction;
    private int piecesToElongate;

    public Snake() {
        super(Constants.SNAKE_COLOR);

        this.direction = Direction.NONE;
        Rect rect = new Rect(Constants.SNAKE_INITIAL_X, Constants.SNAKE_INITIAL_Y, Constants.SNAKE_PIECE_SIZE, Constants.SNAKE_PIECE_SIZE);
        addRect(rect);

        for (int i = 0; i < Constants.SNAKE_SIZE; i++) {
            rect = duplicate(rect, Direction.LEFT);
            addRect(rect);
        }
    }

    public synchronized void move() {
        if (this.direction != Direction.NONE) {
            Rect head = getFirstRect();
            Rect tail = getLastRect();
            GameUtils.moveRect(getRects());
            Rect newHead = duplicate(head, this.direction);
            getRects().set(0, newHead);

            if (piecesToElongate > 0) {
                getRects().add(tail);
                piecesToElongate--;
            }
        }
    }

    public synchronized void up() {
        if (this.direction.canChangeTO(Direction.UP)) {
            direction = Direction.UP;
        }
    }

    public synchronized void down() {
        if (this.direction.canChangeTO(Direction.DOWN)) {
            this.direction = Direction.DOWN;
        }
    }

    public synchronized void left() {
        if (this.direction.canChangeTO(Direction.LEFT)) {
            this.direction = Direction.LEFT;
        }
    }

    public synchronized void right() {
        if (this.direction.canChangeTO(Direction.RIGHT)) {
            this.direction = Direction.RIGHT;
        }
    }

    public boolean collidesWithItself() {
        Rect head = getFirstRect();

        for (int i = 1; i < getRects().size(); i++) {
            Rect rect = getRects().get(i);
            if (head.intersects(rect)) {
                return true;
            }
        }

        return false;
    }

    public void elongate() {
        piecesToElongate = SNAKE_ELONGATE_PIECES;
    }
}
