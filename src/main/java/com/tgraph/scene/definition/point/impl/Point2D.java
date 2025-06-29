package com.tgraph.scene.definition.point.impl;

import java.util.List;

import com.tgraph.scene.definition.point.Point;
import com.tgraph.scene.definition.point.exceptions.InvalidPointOperationException;

/**
 * Implementation of a 2D point.
 * 
 * @author Suvabrata Chowdhury
 */
public class Point2D implements Point{
    private int x;
    private int y;

    private static final int DIMENSION_CNT = 2;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getDimension() {
        return DIMENSION_CNT;
    }

    @Override
    public List<Integer> getCoords() {
        return List.of(x, y);
    }

    @Override
    public void setCoords(final List<Integer> coords) throws InvalidPointOperationException {
        if (coords.size() != DIMENSION_CNT) {
            throw new InvalidPointOperationException(
                "Given coordinate should be of dimension 2 but " + coords.size() + " dimensional point was passed");
        }

        x = coords.get(0);
        y = coords.get(1);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
