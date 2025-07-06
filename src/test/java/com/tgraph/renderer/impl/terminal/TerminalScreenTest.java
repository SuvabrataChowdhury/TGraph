package com.tgraph.renderer.impl.terminal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tgraph.renderer.exception.ScreenDefinitionException;
import com.tgraph.scene.Shape;
import com.tgraph.scene.shape2d.Point2D;
import com.tgraph.scene.shape2d.Shape2D;

public class TerminalScreenTest {

    @AfterEach
    public void cleanUp() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field instanceField = TerminalScreen.class.getDeclaredField("INSTANCE");
        instanceField.setAccessible(true);
        instanceField.set(null, null);
        instanceField.setAccessible(false);
    }

    @DisplayName("Given a height and width, I should be able to create a Terminal Screen")
    @Test
    public void initScreenTest() throws ScreenDefinitionException {
        TerminalScreen tScreen = TerminalScreen.getInstance(10, 10);

        assertEquals(10, tScreen.getHeight());
        assertEquals(10, tScreen.getWidth());
    }

    @DisplayName("Given a defined terminal screen, I should get only that one for further calls")
    @Test
    public void singletonTest() throws ScreenDefinitionException {
        TerminalScreen tScreen1 = TerminalScreen.getInstance(10, 10);
        TerminalScreen tScreen2 = TerminalScreen.getInstance();

        assertEquals(tScreen2, tScreen1);
    }

    @DisplayName("Given a defined terminal screen, I should not be able to modify it for now")
    @Test
    public void immutabilityTest() throws ScreenDefinitionException {
        TerminalScreen tScreen1 = TerminalScreen.getInstance(10,10);
        
        assertThrows(ScreenDefinitionException.class, () -> TerminalScreen.getInstance(20, 20));
    }

    @DisplayName("Given zero or negative height or width, I should not be able to define a terminal")
    @Test
    public void negativeHeightWidthTest() {
        assertThrows(ScreenDefinitionException.class, () -> TerminalScreen.getInstance(-10, 5));
        assertThrows(ScreenDefinitionException.class, () -> TerminalScreen.getInstance(10, -5));
        assertThrows(ScreenDefinitionException.class, () -> TerminalScreen.getInstance(-10, -5));
        assertThrows(ScreenDefinitionException.class, () -> TerminalScreen.getInstance(0, 5));
        assertThrows(ScreenDefinitionException.class, () -> TerminalScreen.getInstance(0, 0));
    }

    @DisplayName("Given a terminal screen, I should get its output as Terminal")
    @Test
    public void getOutputTest() throws ScreenDefinitionException {
        assertEquals("Terminal", TerminalScreen.getInstance(10, 10).getOutput());
    }

    @DisplayName("Given a terminal screen and a shape, I can render it and get back a renderable object")
    @Test
    public void renderTest() throws ScreenDefinitionException {
        TerminalScreen tScreen = TerminalScreen.getInstance(10,10);

        Shape2D mockShape = mock(Shape2D.class);

        assertTrue(tScreen.render(mockShape) instanceof TerminalRenderableShape);
        
        assertEquals(mockShape, tScreen.getRenderableShapes().get(0).getShape());
    }

    @DisplayName("Given a shape, I should be able to render it in terminal")
    @Test
    public void flushTest() throws ScreenDefinitionException {
        TerminalScreen tScreen = TerminalScreen.getInstance(10,10);

        Shape2D mockShape = mock(Shape2D.class);

        Point2D point = new Point2D(5, 5);

        doReturn(List.of(point)).when(mockShape).getPoints();

        tScreen.render(mockShape).setStyle(p -> '&');

        tScreen.flush();
        verify(mockShape,times(1)).getPoints();
    }

}
