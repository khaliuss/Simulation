package org.example;

import org.example.abstraction.*;
import org.example.dynamicentity.Carrot;
import org.example.dynamicentity.Rabbit;
import org.example.dynamicentity.Wolf;

import java.util.*;

import static org.example.Constants.GRID_COL;
import static org.example.Constants.GRID_ROW;

public class PathFinder {

    private GameMap gameMap;
    private Class<? extends Entity> toHunt;


    Queue<Coordinate> queue = new LinkedList<>();
    HashMap<Coordinate, Coordinate> visited = new HashMap<>();

    public PathFinder(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    int[] dRow = new int[]{0, -1, -1, -1, 0, +1, +1, +1};
    int[] dCol = new int[]{+1, +1, 0, -1, -1, -1, 0, +1};

    private void findAvailable(Coordinate cameFrom, Entity foodSeeker) {
        for (int i = 0; i < 8; i++) {
            int moveRow = dRow[i] + cameFrom.X;
            int moveCol = dCol[i] + cameFrom.Y;
            if ((moveRow >= 0 && moveRow < GRID_ROW) && (moveCol >= 0 && moveCol < GRID_COL)) {
                Coordinate coordinate = new Coordinate(moveRow, moveCol);
                if (gameMap.getEntity(coordinate) instanceof Obstacle) {
                    continue;
                }
                if (foodSeeker instanceof Predator){
                    if (gameMap.getEntity(coordinate) instanceof Predator || gameMap.getEntity(coordinate) instanceof Carrot){
                        continue;
                    }
                }

                if (foodSeeker instanceof Herbivore){
                    if (gameMap.getEntity(coordinate) instanceof Herbivore || gameMap.getEntity(coordinate) instanceof Predator){
                        continue;
                    }
                }

                if (!visited.containsKey(coordinate)) {
                    queue.add(coordinate);
                    visited.put(coordinate, cameFrom);
                }
            }
        }
    }

    public List<Coordinate> find(Coordinate currentPosition, Entity foodSeeker) {
        queue.clear();
        visited.clear();
        List<Coordinate> path = new ArrayList<>();
        queue.add(currentPosition);
        visited.put(currentPosition, null);
        if (foodSeeker instanceof Wolf) {
            toHunt = Rabbit.class;
        } else if (foodSeeker instanceof Rabbit) {
            toHunt = Carrot.class;
        }

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            Entity currentEntity = gameMap.getEntity(current);

            if (toHunt.isInstance(currentEntity)) {
                Coordinate neighborKey = current;
                path.add(neighborKey);
                while (true) {
                    Coordinate neighbor = visited.get(neighborKey);
                    if (neighbor == null) {
                        break;
                    }
                    path.add(neighbor);
                    neighborKey = neighbor;
                }
                Collections.reverse(path);
                path.removeFirst();
                return path;
            } else {
                findAvailable(current, foodSeeker);
            }
        }

        return path;
    }

}

