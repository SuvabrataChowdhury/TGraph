package com.tgraph.scene;

import java.util.List;

public interface Shape<T extends Point> {
    public List<T> getPoints();
}
