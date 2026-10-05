package org.example.abstraction;

import org.example.GameMap;
import org.example.PathFinder;

public abstract class Predator extends Creature {

    public Predator(Coordinate coordinate, GameMap gameMap, PathFinder pathFinder) {
        super(coordinate, gameMap, pathFinder);
    }

    public abstract void attack(Herbivore target);
}
