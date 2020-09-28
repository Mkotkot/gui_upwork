package controller;

import model.ShapeList;
import model.commands.CreateShapeCommand;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IMouseDragStrategy;
import model.interfaces.IMouseReleasedStrategy;
import model.strategies.DrawMouseDragStrategy;
import model.strategies.DrawMouseReleasedStrategy;

public class CommandController {
    private static MouseHandler mouse;
    private static IApplicationState app;
    private static ShapeList shapeList;
    private static ICommand command = null;

    public static void setup(MouseHandler m, IApplicationState a) {
        mouse = m;
        app = a;
        shapeList = ShapeList.getInstance();
    }

    public static void mousePressed() {
        command = new CreateShapeCommand(mouse, app);


        command.run();
    }

    public static void mouseDragged() {
        IMouseDragStrategy strat = null;

        strat = new DrawMouseDragStrategy(mouse);


        strat.run();
        shapeList.updateShapes();
    }

    public static void mouseReleased() {
        IMouseReleasedStrategy strat = null;

        strat = new DrawMouseReleasedStrategy();

        strat.run();
        shapeList.updateShapes();
    }

}
