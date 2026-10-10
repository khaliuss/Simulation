package org.example.staticentity;

import org.example.abstraction.Coordinate;
import org.example.abstraction.Obstacle;

import static org.example.Constants.TREE_EMOJI;

public class Tree extends Obstacle {
    public Tree(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public String toString() {
        return TREE_EMOJI;
    }
}
