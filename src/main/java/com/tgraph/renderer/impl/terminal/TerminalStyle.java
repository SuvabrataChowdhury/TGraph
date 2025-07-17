package com.tgraph.renderer.impl.terminal;

import com.tgraph.renderer.Style;
import com.tgraph.scene.shape2d.Point2D;

/**
 * Style in terminal is a function which maps each pixels on screen to an ASCII character.
 * It is to be supplied from user.
 * 
 * @author Suvabrata Chowdhury
 */
@FunctionalInterface
public interface TerminalStyle extends Style{
    public char getRenderingCharacter(Point2D point);
}
