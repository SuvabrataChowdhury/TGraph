package com.tgraph.scene.shape2d;

import java.util.List;

import com.tgraph.scene.Point;
import com.tgraph.scene.exceptions.InvalidPointOperationException;

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

    public Point2D(Point2D point) {
        this.x = point.getX();
        this.y = point.getY();
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point2D other = (Point2D) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
