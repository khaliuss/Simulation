package org.example.abstraction;

import org.example.GameMap;
import org.example.dynamic_entity.Carrot;
import org.example.dynamic_entity.Rabbit;
import org.example.static_entity.Rock;

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

    private void findAvailable(Coordinate cameFrom, Entity hunter) {
        for (int i = 0; i < 8; i++) {
            int moveRow = dRow[i] + cameFrom.coordinateX;
            int moveCol = dCol[i] + cameFrom.coordinateY;
            if ((moveRow >= 0 && moveRow < GRID_ROW) && (moveCol >= 0 && moveCol < GRID_COL)) {
                Coordinate coordinate = new Coordinate(moveRow, moveCol);
                if (gameMap.getEntity(coordinate) instanceof Rock) {
                    continue;
                }

                if (hunter instanceof Rabbit){
                    if (gameMap.getEntity(coordinate) instanceof Rabbit ){
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

    public List<Coordinate> targetCoordinate(Coordinate currentPosition, Entity hunter) {
        queue.clear();
        visited.clear();
        List<Coordinate> path = new ArrayList<>();
        queue.add(currentPosition);
        visited.put(currentPosition, null);

        if (hunter instanceof Rabbit) {
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
                findAvailable(current, hunter);
            }
        }

        return path;
    }

}



