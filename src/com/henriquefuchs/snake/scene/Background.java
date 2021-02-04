package com.henriquefuchs.snake.scene;

import com.henriquefuchs.snake.graphics.Rect;
import com.henriquefuchs.snake.util.Constants;

public class Background extends Rect {

    public Background() {
        super(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setColor(Constants.BACKGROUND_COLOR);
    }
}
