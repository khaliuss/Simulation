package org.example.abstraction;

public abstract class Herbivore extends Creature {


    public Herbivore(Coordinate coordinate) {
        super(coordinate);
    }

    public abstract void Eat();
}
