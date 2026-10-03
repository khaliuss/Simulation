package org.example.actions.turns;

import org.example.GameMap;
import org.example.PathFinder;
import org.example.abstraction.Coordinate;
import org.example.abstraction.Entity;
import org.example.actions.TurnAction;
import org.example.dynamic_entity.Rabbit;
import org.example.dynamic_entity.Wolf;

import java.util.*;

public class WolfTurnAction extends TurnAction {

    private Deque<Coordinate> targetQueue = new ArrayDeque<>();

    @Override
    public void makeMove(GameMap map, PathFinder pathFinder) {
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

}


/*
            if (coordinate != null) {
                Entity entity = map.getEntity(coordinate);
                targetQueue.addAll(pathFinder.targetCoordinate(coordinate,entity));
                //TODO (temp realization of steps)
                Coordinate targetCoordinate = targetQueue.poll();
                for (int i = 0; i < 2; i++) {

                }
                if (targetCoordinate == null) {
                    return;
                }
                map.putEntity(targetQueue.poll(), map.getEntity(coordinate));
                map.deleteEntity(coordinate);
                targetQueue.clear();
            }
*/
