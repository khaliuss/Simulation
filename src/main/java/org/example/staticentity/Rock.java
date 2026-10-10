package org.example.staticentity;

import org.example.abstraction.Coordinate;
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
