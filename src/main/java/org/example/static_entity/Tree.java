package org.example.static_entity;

import org.example.abstraction.Coordinate;
import org.example.abstraction.Entity;

import static org.example.Constants.TREE_EMOJI;

public class Tree extends Entity {
    public Tree(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public String toString() {
        return TREE_EMOJI;
    }
}
