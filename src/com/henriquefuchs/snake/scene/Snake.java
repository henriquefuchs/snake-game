package com.henriquefuchs.snake.scene;

import com.henriquefuchs.snake.core.Direction;
import com.henriquefuchs.snake.graphics.Rect;
import com.henriquefuchs.snake.graphics.Shape;
import com.henriquefuchs.snake.util.Constants;
import com.henriquefuchs.snake.util.GameUtils;

public class Snake extends Shape {
    private Direction direction;

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

    public void move() {
        if (this.direction != Direction.NONE) {
            Rect head = getFirstRect();
            GameUtils.moveRect(getRects());
            Rect newHead = duplicate(head, this.direction);
            getRects().set(0, newHead);
        }
    }

    public void up() {
        if (this.direction.canChangeTO(Direction.UP)) {
            direction = Direction.UP;
        }
    }

    public void down() {
        if (this.direction.canChangeTO(Direction.DOWN)) {
            this.direction = Direction.DOWN;
        }
    }

    public void left() {
        if (this.direction.canChangeTO(Direction.LEFT)) {
            this.direction = Direction.LEFT;
        }
    }

    public void right() {
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
}
