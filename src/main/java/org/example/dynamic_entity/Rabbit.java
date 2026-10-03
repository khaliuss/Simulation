package org.example.dynamic_entity;

import org.example.abstraction.Coordinate;
import org.example.abstraction.Herbivore;

import static org.example.Constants.RABBIT_EMOJI;

public class Rabbit extends Herbivore {

    public Rabbit(Coordinate coordinate) {
        super(coordinate);

    }

    @Override
    public void makeMove() {

    }

    @Override
    public void Eat() {

    }

    @Override
    public String toString() {
        return RABBIT_EMOJI;
    }
}
