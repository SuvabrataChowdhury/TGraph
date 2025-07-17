package com.tgraph.renderer.impl.terminal;

import java.util.ArrayList;
import java.util.List;

import com.tgraph.renderer.Screen;
import com.tgraph.renderer.exception.ScreenDefinitionException;
import com.tgraph.scene.shape2d.Point2D;
import com.tgraph.scene.shape2d.Shape2D;

/**
 * Implementation of screen which is to be rendered in terminal.
 * 
 * @author Suvabrata Chowdhury
 */
//TODO: delegate the rendering task to JLine which is a powerful framework to interact with terminal
public class TerminalScreen implements Screen<Shape2D, TerminalRenderableShape> {
    private int height;
    private int width;

    private List<TerminalRenderableShape> renderableShapes = new ArrayList<>();
    private char[][] grid;

    //TODO: Move these to some factory/ builder
    private static final String TERMINAL_OUTPUT = "Terminal";
    private static final int DEFAULT_HEIGHT = 50;
    private static final int DEFAULT_WIDTH = 50;

    private static TerminalScreen INSTANCE = null;

    private TerminalScreen(final int height, final int width) {
        this.height = height;
        this.width = width;

        grid = new char[height][width];
    }

    public static TerminalScreen getInstance() {
        return INSTANCE;
    }

    public static TerminalScreen getInstance(final int height, final int width) throws ScreenDefinitionException {
        
        if  (height<=0 || width<=0) {
            throw new ScreenDefinitionException("Terminal Screen can not have negative or zero height or width");
        }

        //TODO: For now let resolution be fixed but in future with the introduction of clipping,
        // we might be able to change the resolution during run-time
        if (null != INSTANCE) {
            throw new ScreenDefinitionException("Once Defined a Terminal Screen can not be redefined");
        }

        INSTANCE = new TerminalScreen(height, width);
        return getInstance();
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public String getOutput() {
        return TERMINAL_OUTPUT;
    }

    @Override
    public TerminalRenderableShape render(Shape2D shape) {
        TerminalRenderableShape renderableShape = new TerminalRenderableShape(shape);
        renderableShapes.add(renderableShape);

        return renderableShape;
    }

    //TODO: Modify this implementation
    @Override
    public void flush() {
        //Clear the screen
        grid = new char[this.height][this.width];

        for (TerminalRenderableShape renderableShape : renderableShapes) {
            Shape2D shape = renderableShape.getShape();
            TerminalStyle style = renderableShape.getStyle();

            for (Point2D point: shape.getPoints()) {
                grid[point.getX()][point.getY()] = style.getRenderingCharacter(point);
            }
        }

        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                if (grid[x][y] != '\0'){
                    System.out.print(grid[x][y]);
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println("");
        }
    }

    @Override
    public List<TerminalRenderableShape> getRenderableShapes() {
        return this.renderableShapes;
    }

}
