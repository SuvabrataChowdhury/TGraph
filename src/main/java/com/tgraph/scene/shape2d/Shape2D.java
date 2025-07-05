package com.tgraph.scene.shape2d;

import java.util.List;

import com.tgraph.scene.Shape;

public interface Shape2D extends Shape<Point2D>{
    @Override
    public List<Point2D> getPoints();
}
