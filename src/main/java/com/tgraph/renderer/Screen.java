package com.tgraph.renderer;

/**
 * An abstracted representation of physical screen where Shapes are to be rendered.
 * @author Suvabrata Chowdhury
 */
//Simplest Implementation of Screen which renders to Terminal
public class Screen {
    private int height;
    private int width;
    
    private char[][] grid;

    public Screen(int height, int width) {
        this.height = height;
        this.width = width;

        grid = new char[height][width];

        //TODO: too low level access. delegate it to some other module
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    //TODO: Be able to render an entire shape
    public void render(char c, int x, int y) {
        grid[x][y] = c;
    }

    public void display() {
        //TODO: too low level access. delegate it to some other module
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                System.out.print(grid[i][j]);
            }

            System.out.println("");
        }
    }
}
