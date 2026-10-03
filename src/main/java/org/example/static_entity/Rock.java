package org.example.static_entity;

import org.example.abstraction.Coordinate;
import org.example.abstraction.Entity;

import static org.example.Constants.ROCK_EMOJI;

public class Rock extends Entity {
    public Rock(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public String toString() {
        return ROCK_EMOJI;
    }
}
