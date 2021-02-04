package com.henriquefuchs.snake.graphics;

import com.henriquefuchs.snake.core.Direction;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Shape extends Drawable {

    private List<Rect> rects;

    public Shape(Color color) {
        super(color);
        rects = new ArrayList<>();
    }

    public void addRect(Rect rect) {
        rects.add(rect);
    }

    @Override
    public void draw(Graphics g) {
        for (Rect r : rects) {
            r.draw(g);
        }
    }

    public Rect duplicate(Rect baseRect, Direction direction) {
        int baseX = (int) baseRect.getLocation().getX();
        int baseY = (int) baseRect.getLocation().getY();
        int baseWidth = (int) baseRect.getDimension().getWidth();
        int baseHeight = (int) baseRect.getDimension().getHeight();

        Point newPoint = new Point(
                baseX + direction.getSgnX() * baseWidth,
                baseY + direction.getSgnY() * baseHeight
        );
        return new Rect(newPoint, baseRect.getDimension());
    }

    public List<Rect> getRects() {
        return rects;
    }

    public Rect getFirstRect() {
        return rects.get(0);
    }

    public Rect getLastRect() {
        return rects.get(rects.size() - 1);
    }

    public boolean intersects(Rect rect) {
        for (Rect r : rects) {
            if (r.intersects(rect)) {
                return true;
            }
        }
        return false;
    }
}
