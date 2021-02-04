package com.henriquefuchs.snake.util;

import com.henriquefuchs.snake.graphics.Rect;

import java.util.List;

public class GameUtils {

    public static void moveRect(List<Rect> rects) {
        for (int i = rects.size() - 1; i >= 1; i--) {
            rects.set(i, rects.get(i - 1));
        }
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
