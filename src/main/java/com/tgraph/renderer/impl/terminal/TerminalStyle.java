package com.tgraph.renderer.impl.terminal;

import com.tgraph.renderer.Style;
import com.tgraph.scene.shape2d.Point2D;

@FunctionalInterface
public interface TerminalStyle extends Style{
    public char getRenderingCharacter(Point2D point);
}
