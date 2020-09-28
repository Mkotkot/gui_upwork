package model.commands;

import controller.MouseHandler;
import model.ShapeColor;
import model.ShapeFactory;
import model.ShapeList;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShape;

import java.util.ArrayList;

public class CreateShapeCommand implements ICommand {
    private static IApplicationState app;
    private static MouseHandler mouse;
    private static ShapeList shapeList;
    private IShape shape;

    public CreateShapeCommand(MouseHandler m, IApplicationState a) {
        app = a;
        mouse = m;
        shapeList = ShapeList.getInstance();
    }


    @Override
    public void run() {
        int minX = mouse.getMinX();
        int minY = mouse.getMinY();
        int width = mouse.getWidth();
        int height = mouse.getHeight();
        ShapeColor primaryColor;
        ShapeColor secondaryColor;

        if (mouse.getReverse()) {
            primaryColor = app.getActiveSecondaryColor();
            secondaryColor = app.getActivePrimaryColor();
        } else {
            primaryColor = app.getActivePrimaryColor();
            secondaryColor = app.getActiveSecondaryColor();
        }

        ShapeShadingType shade = app.getActiveShapeShadingType();

        switch (app.getActiveShapeType()) {
            case ELLIPSE:
                shape = ShapeFactory.createEllipse(primaryColor, secondaryColor, shade, minX, minY, width, height);
                break;
            case RECTANGLE:
                shape = ShapeFactory.createRectangle(primaryColor, secondaryColor, shade, minX, minY, width, height);
                break;
            case TRIANGLE:
                shape = ShapeFactory.createTriangle(primaryColor, secondaryColor, shade, minX, minY, width, height);
                break;
        }

        shapeList.addShape(shape);
        ArrayList<IShape> newList = new ArrayList<IShape>();
        newList.add(shape);
        shapeList.setSelectedShapes(newList);
        shapeList.updateShapes();
    }
}
