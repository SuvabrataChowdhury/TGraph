package com.tgraph.scene.definition.point.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tgraph.scene.definition.point.exceptions.InvalidPointOperationException;

@DisplayName("Point2D Test")
public class Point2DTest {
    
    Point2D p;

    @BeforeEach
    public void setUp() {
        p = new Point2D(20, 80);
    }

    @DisplayName("Given a point in 2D, When I ask for its dimension and coords, Then I get 2 and declared coords respectively")
    @Test
    public void definitionTest() {

        assertEquals(2,p.getDimension());
        assertIterableEquals(List.of(20,80), p.getCoords());
    }

    @DisplayName("Given a point in 2D, When I set it's coords to something new, Then the coords get changed")
    @Test
    public void coordsChangeTest() throws InvalidPointOperationException {
        p.setCoords(List.of(0,0));
        assertIterableEquals(List.of(0,0), p.getCoords());
    }

    @DisplayName("Given a point in 2D, When I set it's coords to some different dimensional coords, Then I get an error and coords should not be changed")
    @Test
    public void invalidCoordsChangeTest() throws InvalidPointOperationException {

        assertThrows(InvalidPointOperationException.class, () -> p.setCoords(List.of(0,0,0)));
        assertIterableEquals(List.of(20,80), p.getCoords());

        assertThrows(InvalidPointOperationException.class, () -> p.setCoords(List.of(0)));
        assertIterableEquals(List.of(20,80), p.getCoords());
    }

    @DisplayName("Given a point in 2D, When I mutate and access a component, Then only that component should be mutated or accessed")
    @Test
    public void componentAccessMutateTest() {
        p.setX(0);
        assertEquals(0, p.getX());
        assertIterableEquals(List.of(0,80), p.getCoords());

        p.setY(0);
        assertEquals(0, p.getY());
        assertIterableEquals(List.of(0,0), p.getCoords());
    }
}