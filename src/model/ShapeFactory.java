package model;

import model.interfaces.IShape;
import model.shapes.Ellipse;
import model.shapes.Rectangle;
import model.shapes.Triangle;

public class ShapeFactory {

    public static IShape createEllipse(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int xMin, int xMax, int yMin, int yMax) {
        return new Ellipse(primaryColor, secondaryColor, shade, xMin, xMax, yMin, yMax);
    }


    public static IShape createRectangle(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int xMin, int xMax, int yMin, int yMax) {
        return new Rectangle(primaryColor, secondaryColor, shade, xMin, xMax, yMin, yMax);
    }


    public static IShape createTriangle(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int xMin, int xMax, int yMin, int yMax) {
        return new Triangle(primaryColor, secondaryColor, shade, xMin, xMax, yMin, yMax);
    }

}
