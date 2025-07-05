package com.tgraph.scene.shape2d.box;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tgraph.scene.shape2d.Point2D;

public class BoxTest {

    @DisplayName("Given major diagonal, I should get all points on it's perimeter")
    @Test
    public void getPointsTest() {
        Box box = new Box(new Point2D(10, 10), new Point2D(20, 20));
        List<Point2D> points = box.getPoints();

        List<Point2D> cornerPoints = List.of(new Point2D(10, 10),
                                            new Point2D(10, 20),
                                            new Point2D(20, 10),
                                            new Point2D(20, 20));
        assertTrue(cornerPoints.stream().allMatch(p -> points.contains(p)));
    }

    //TODO: Make it pass/ rectify it
    @DisplayName("Given negative sloped diagonal, I should get all points on it's perimeter")
    @Disabled("Temporarily Disabled. Will enable once lines are incorporated")
    @Test
    public void getPointsNegativeSlopeDiagonalTest() {
        Box box = new Box(new Point2D(20, 20), new Point2D(10, 10));
        List<Point2D> points = box.getPoints();

        List<Point2D> cornerPoints = List.of(new Point2D(10, 10),
                                            new Point2D(10, 20),
                                            new Point2D(20, 10),
                                            new Point2D(20, 20));
        assertTrue(cornerPoints.stream().allMatch(p -> points.contains(p)));
    }
}
