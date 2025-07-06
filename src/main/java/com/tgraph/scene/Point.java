package com.tgraph.scene;

import java.util.List;

import com.tgraph.scene.exceptions.InvalidPointOperationException;

/**
 * Interface for a Point in any dimension.
 * 
 * @author Suvabrata Chowdhury
 */
public interface Point {
    public int getDimension();
    public List<Integer> getCoords();

    /**
     * Sets coordinate of the point given {@code coords}, an ordered list of integers.
     * <p><strong>Note:</strong> Throws {@code InvalidPointOperationException} incase dimension mismatches.</p>
     */
    public void setCoords(final List<Integer> coords) throws InvalidPointOperationException;
}