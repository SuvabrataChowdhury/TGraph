package com.tgraph.renderer.impl.terminal;

import com.tgraph.renderer.RenderableShape;
import com.tgraph.scene.shape2d.Shape2D;

/**
 * Implementation of all shapes that are renderable on terminal.
 * 
 * @author Suvabrata Chowdhury
 */
public class TerminalRenderableShape implements RenderableShape<Shape2D, TerminalStyle>{
    private Shape2D shape;
    private TerminalStyle style;

    public TerminalRenderableShape(Shape2D shape) {
        this.shape = shape;
        this.style = p -> '*'; //For now the default character
    }

    @Override
    public Shape2D getShape() {
        return this.shape;
    }

    @Override
    public TerminalStyle getStyle() {
        return this.style;
    }

    @Override
    public void setStyle(TerminalStyle style) {
        this.style = style;
    }


}
