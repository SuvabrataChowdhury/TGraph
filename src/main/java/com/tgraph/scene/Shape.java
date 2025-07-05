package com.tgraph.scene;

import java.util.List;

/**
 * Interface for all shapes (in any dimension) in general.
 * 
 * @author Suvabrata Chowdhury
 */
public interface Shape<T extends Point> {
    public List<T> getPoints();
}
