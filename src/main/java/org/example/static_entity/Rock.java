package org.example.static_entity;

import org.example.abstraction.Coordinate;
import org.example.abstraction.Entity;
import org.example.abstraction.Obstacle;

import static org.example.Constants.ROCK_EMOJI;

public class Rock extends Obstacle {
    public Rock(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public String toString() {
        return ROCK_EMOJI;
    }
}
