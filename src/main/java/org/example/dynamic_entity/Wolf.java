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
        this.hp -= 2;
        if (this.hp <= 0) {
            gameMap.deleteEntity(this.coordinate);
            return;
        }
        targetQueue.addAll(pathFinder.targetCoordinate(coordinate, this));

        for (int i = 0; i < speed; i++) {
            Coordinate newCoordinate = targetQueue.poll();
            if (newCoordinate == null) {
                return;
            }
            if (gameMap.getEntity(newCoordinate) instanceof Herbivore herbivore) {
                attack(herbivore);
            }
            gameMap.putEntity(newCoordinate, this);
            gameMap.deleteEntity(coordinate);
            this.coordinate = newCoordinate;
            targetQueue.clear();
        }
    }

    @Override
    public boolean isDead() {
        return this.hp<=0;
    }

    @Override
    public void attack(Herbivore target) {
        target.wounded(100);
        if (target.isDead()) {
            this.hp = Math.min(hp+30,100);
        }
    }

    @Override
    public String toString() {
        return WOLF_EMOJI;
    }
}

