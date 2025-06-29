package com.tgraph.renderer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

//TODO: Better assert some stuff
public class ScreenTest {
    private Screen screen;

    @BeforeEach
    public void setUp() {
        screen = new Screen(10, 10);
    }

    @Test
    public void renderTest() {
        // screen = new Screen(20, 20);
        screen.render('\\',5 , 5);
        screen.display();
    }
}