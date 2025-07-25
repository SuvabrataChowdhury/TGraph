package com.tgraph.renderer;

import java.util.List;

import com.tgraph.scene.Point;
import com.tgraph.scene.Shape;

/**
 * An interface defining all generic functionalities of any Screen.
 * 
 * @author Suvabrata Chowdhury
 */
public interface Screen<S extends Shape<? extends Point>, T extends RenderableShape<S, ?>> {
    public int getHeight();
    public int getWidth();

    public String getOutput();
    public T render(S shape);
    public void flush();

    public List<T> getRenderableShapes();
}
