package com.henriquefuchs.snake.graphics;

import java.awt.*;

public abstract class Drawable {

    private Color color;

    public Drawable() {
        this.color = Color.BLACK;
    }

    public Drawable(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(Graphics g);
}
