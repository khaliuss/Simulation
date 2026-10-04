/*
package org.example.dynamic_entity;

import org.example.GameMap;
import org.example.PathFinder;
import org.example.abstraction.Coordinate;
import org.example.abstraction.Entity;
import org.example.abstraction.Predator;

import java.util.*;

import static org.example.Constants.WOLF_EMOJI;

public class Wolf extends Predator {
    protected final int speed = 2;

    public Wolf(Coordinate coordinate) {
        super(coordinate);
    }

    private Deque<Coordinate> targetQueue = new ArrayDeque<>();

    @Override
    public void makeMove() {
        List<Coordinate> allRabbitsCoordinate = new ArrayList<>();
        for (Map.Entry<Coordinate, Entity> entity : map.getEntities().entrySet()) {
            if (entity.getValue() instanceof Wolf) {
                allRabbitsCoordinate.add(entity.getKey());
            }
        }

        for (Coordinate coordinate : allRabbitsCoordinate) {
            if (coordinate != null) {
                Entity entity = map.getEntity(coordinate);
                targetQueue.addAll(pathFinder.targetCoordinate(coordinate,entity));
                Coordinate targetCoordinate = targetQueue.poll();
                if (targetCoordinate == null) {
                    return;
                }
                map.putEntity(targetCoordinate, map.getEntity(coordinate));
                map.deleteEntity(coordinate);
                targetQueue.clear();
            }
        }

    }

    @Override
    public void Attack() {

    }

    @Override
    public String toString() {
        return WOLF_EMOJI;
    }
}
*/
