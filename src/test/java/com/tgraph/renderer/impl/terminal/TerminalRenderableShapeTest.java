package com.tgraph.renderer.impl.terminal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tgraph.scene.shape2d.Point2D;
import com.tgraph.scene.shape2d.Shape2D;

public class TerminalRenderableShapeTest {

    @Mock
    private Shape2D mockShape;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @DisplayName("Given a Shape, I should be able to get a terminal renderable shape out of it")
    @Test
    public void instantationTest() {
        TerminalRenderableShape tRenderableShape = new TerminalRenderableShape(mockShape);

        assertEquals(mockShape, tRenderableShape.getShape());

        tRenderableShape.setStyle(p -> '\\');

        assertEquals('\\', tRenderableShape.getStyle().getRenderingCharacter(mock(Point2D.class)));
    }
}
