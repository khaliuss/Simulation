package org.example.dynamic_entity;

import org.example.abstraction.Coordinate;
import org.example.abstraction.Predator;

import static org.example.Constants.WOLF_EMOJI;

public class Wolf extends Predator {
    protected final int speed = 2;

    public Wolf(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public void makeMove() {

    }

    @Override
    public void Attack() {

    }

    @Override
    public String toString() {
        return WOLF_EMOJI;
    }
}
