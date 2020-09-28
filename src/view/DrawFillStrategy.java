package view;

import model.interfaces.IShape;
import view.interfaces.IDrawStrategy;

import java.awt.*;

public class DrawFillStrategy implements IDrawStrategy {
    private IShape shape;
    private Graphics2D g2d;

    public DrawFillStrategy(IShape shape, Graphics2D g2d) {
        this.shape = shape;
        this.g2d = g2d;
    }

    public void draw() {
        g2d.setColor(Color.green);
        int x = shape.getMinX();
        int y = shape.getMinY();
        int w = shape.getWidth();
        int h = shape.getHeight();

        switch (shape.toString()) {
            case "RECTANGLE":
                g2d.fillRect(x, y, w, h);
                break;
            case "ELLIPSE":
                g2d.fillOval(x, y, w, h);
                break;
            case "TRIANGLE":
                int[] xPoints = {x + w, x, x + w};
                int[] yPoints = {y, y + h, y + h};
                g2d.fillPolygon(xPoints, yPoints, 3);
                break;
            default:
                break;
        }
    }
}
