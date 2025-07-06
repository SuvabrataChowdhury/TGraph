package com.tgraph.renderer;

import com.tgraph.scene.Point;
import com.tgraph.scene.Shape;

public interface RenderableShape<T extends Shape<? extends Point>, S extends Style> {
    public T getShape();
    public S getStyle();
    public void setStyle(S style);
}
