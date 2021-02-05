package com.henriquefuchs.snake.graphics;

import java.awt.*;

public class Rect extends Drawable {
    private Rectangle rectangle;

    public Rect() {
        this.rectangle = new Rectangle(0, 0, 0, 0);
    }

    public Rect(int x, int y, int width, int height) {
        this.rectangle = new Rectangle(x, y, width, height);
    }

    public Rect(Point location, Dimension dimension) {
        this.rectangle = new Rectangle(location, dimension);
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(
                (int) rectangle.getLocation().getX(),
                (int) rectangle.getLocation().getY(),
                (int) rectangle.getSize().getWidth(),
                (int) rectangle.getSize().getHeight()
        );
    }

    public void setLocation(Point location) {
        this.rectangle.setLocation(location);
    }

    public void setDimension(Dimension dimension) {
        this.rectangle.setSize(dimension);
    }

    public boolean intersects(Rect other) {
        return rectangle.intersects(other.rectangle);
    }

    public Point getLocation() {
        return this.rectangle.getLocation();
    }

    public Dimension getDimension() {
        return this.rectangle.getSize();
    }
}
