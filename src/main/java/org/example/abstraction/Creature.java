package org.example.abstraction;

public abstract class Creature extends Entity {

    protected final int speed = 1;
    protected int hp = 100;

    public Creature(Coordinate coordinate) {
        super(coordinate);

    }

    public abstract void makeMove();


}
