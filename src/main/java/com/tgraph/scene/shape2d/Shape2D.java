package com.tgraph.scene.shape2d;

import java.util.List;

import com.tgraph.scene.Shape;
/**
 * Interface for all 2-Dimensional Shapes.
 * 
 * @author Suvabrata Chowdhury
 */
public interface Shape2D extends Shape<Point2D>{
    @Override
    public List<Point2D> getPoints();

    //TODO: Add Method to linearly transform the shape (Depicted in architecture)
}
