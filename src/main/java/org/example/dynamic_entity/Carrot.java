package org.example.dynamic_entity;

import org.example.abstraction.Coordinate;
import org.example.abstraction.Entity;

import static org.example.Constants.CARROT_EMOJI;

public class Carrot extends Entity {
    public Carrot(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public String toString() {
        return CARROT_EMOJI;
    }
}
