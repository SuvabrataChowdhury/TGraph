package com.tgraph.scene.shape2d.box;

import java.util.ArrayList;
import java.util.List;

import com.tgraph.scene.shape2d.Point2D;
import com.tgraph.scene.shape2d.Shape2D;

/**
 * Box 2D shape to draw a box.
 * 
 * @author Suvabrata Chowdhury
 */
//TODO: Use 4 Lines to draw the box
public class Box implements Shape2D{
    private Point2D majorDiagonalPoint1;
    private Point2D majorDiagonalPoint2;

    private List<Point2D> points;

    public Box(Point2D majorDiagonalPoint1, Point2D majorDiagonalPoint2) {
        this.majorDiagonalPoint1 = majorDiagonalPoint1;
        this.majorDiagonalPoint2 = majorDiagonalPoint2;

        points = new ArrayList<>();
    }

    //TODO: Optimize the point generation i.e., 
    // when the defining attributes are moved then only generate the points else return existing generated points.
    // This way it will implement lazy loading
    @Override
    public List<Point2D> getPoints() {

        //Top Edge
        for (int x = majorDiagonalPoint1.getX(); x < majorDiagonalPoint2.getX(); x++) {
            points.add(new Point2D(x, majorDiagonalPoint1.getY()));
        }

        //Right Edge
        for (int y = majorDiagonalPoint1.getY(); y < majorDiagonalPoint2.getY(); y++) {
            points.add(new Point2D(majorDiagonalPoint2.getX(), y));
        }

        //Bottom Edge
        for (int x = majorDiagonalPoint2.getX(); x > majorDiagonalPoint1.getX(); x--) {
            points.add(new Point2D(x, majorDiagonalPoint2.getY()));
        }

        //Left Edge
        for (int y = majorDiagonalPoint2.getY(); y > majorDiagonalPoint1.getY(); y--) {
            points.add(new Point2D(majorDiagonalPoint1.getX(), y));
        }
        
        return points;
    }

}
