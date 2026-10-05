package org.example.dynamic_entity;

import org.example.GameMap;
import org.example.PathFinder;
import org.example.abstraction.Coordinate;
import org.example.abstraction.Herbivore;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.example.Constants.RABBIT_EMOJI;

public class Rabbit extends Herbivore {

    private Deque<Coordinate> targetQueue = new ArrayDeque<>();


    public Rabbit(Coordinate coordinate, GameMap gameMap, PathFinder pathFinder) {
        super(coordinate,gameMap,pathFinder);
    }

    @Override
    public void makeMove() {
        if (this.hp <= 0){
            gameMap.deleteEntity(this.coordinate);
            return;
        }
        this.hp-=1;
        targetQueue.addAll(pathFinder.targetCoordinate(coordinate, this));
        for (int i = 0; i < speed; i++) {
            Coordinate newCoordinate = targetQueue.poll();
            if (newCoordinate == null) {
                return;
            }
            if (gameMap.getEntity(newCoordinate) instanceof Carrot){
                eat();
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
    public void eat() {
        this.hp = Math.min(hp+10,100);
    }

    @Override
    public void wounded(int attackLevel) {
        this.hp-=attackLevel;
        gameMap.deleteEntity(this.coordinate);
    }



    @Override
    public String toString() {
        return RABBIT_EMOJI;
    }

}
