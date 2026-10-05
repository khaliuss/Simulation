package org.example.abstraction;


import org.example.GameMap;
import org.example.PathFinder;

public abstract class Creature extends Entity {

    protected final int speed = 1;
    protected int hp = 100;
    protected GameMap gameMap;
    protected final PathFinder pathFinder;

    public Creature(Coordinate coordinate,GameMap gameMap,PathFinder pathFinder) {
        super(coordinate);
        this.gameMap = gameMap;
        this.pathFinder = pathFinder;
    }

    public abstract void makeMove();

    public abstract boolean isDead();


}
