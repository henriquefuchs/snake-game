package snake;

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

    public Rect duplicate(Rect baseRect) {
        int baseX = (int) baseRect.getLocation().getX();
        int baseY = (int) baseRect.getLocation().getY();
        int baseWidth = (int) baseRect.getDimension().getWidth();

        Point newPoint = new Point(baseX - baseWidth, baseY);
        return new Rect(newPoint, baseRect.getDimension());
    }
}
