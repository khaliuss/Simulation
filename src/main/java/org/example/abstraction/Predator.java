package org.example.abstraction;

public abstract class Predator extends Creature {
    public Predator(Coordinate coordinate) {
        super(coordinate);
    }
    public abstract void Attack();
}
