package org.example.abstraction;

import org.example.GameMap;
import org.example.PathFinder;

public abstract class Herbivore extends Creature {


    public Herbivore(Coordinate coordinate, GameMap gameMap, PathFinder pathFinder) {
        super(coordinate,gameMap,pathFinder);
    }

    public abstract void eat();

    public abstract void wounded(int attackLevel);

//    public abstract boolean killed();
}
