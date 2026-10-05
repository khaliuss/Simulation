package org.example.dynamic_entity;

import org.example.GameMap;
import org.example.PathFinder;
import org.example.abstraction.*;

import java.util.*;

import static org.example.Constants.WOLF_EMOJI;

public class Wolf extends Predator {

    protected final int speed = 1;
    private Deque<Coordinate> targetQueue = new ArrayDeque<>();

    public Wolf(Coordinate coordinate, GameMap gameMap, PathFinder pathFinder) {
        super(coordinate, gameMap, pathFinder);
    }

    @Override
    public void makeMove() {
        if (this.hp <= 0) {
            gameMap.deleteEntity(this.coordinate);
            return;
        }
        this.hp -= 1;
        targetQueue.addAll(pathFinder.targetCoordinate(coordinate, this));
        for (int i = 0; i < speed; i++) {
            Coordinate newCoordinate = targetQueue.poll();
            if (newCoordinate == null) {
                return;
            }
            if (gameMap.getEntity(newCoordinate) instanceof Herbivore herbivore) {
                attack(herbivore);
                if (herbivore.killed()){
                    gameMap.putEntity(newCoordinate, this);
                    gameMap.deleteEntity(coordinate);
                    this.coordinate = newCoordinate;
                }
                continue;
            }
            gameMap.putEntity(newCoordinate, this);
            gameMap.deleteEntity(coordinate);
            this.coordinate = newCoordinate;
            targetQueue.clear();
        }
    }

    @Override
    public void attack(Herbivore target) {
        target.wounded(30);
        if (target.killed()) {
            this.hp += 30;
        }
    }

    @Override
    public String toString() {
        return WOLF_EMOJI;
    }
}

