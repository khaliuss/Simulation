package org.example.actions.inits;

import org.example.GameMap;
import org.example.PathFinder;
import org.example.abstraction.Coordinate;
import org.example.actions.InitAction;
import org.example.dynamic_entity.Wolf;

import static org.example.Constants.GRID_COL;
import static org.example.Constants.GRID_ROW;

public class WolfInit extends InitAction {

    private final PathFinder pathFinder;

    public WolfInit(PathFinder pathFinder, GameMap gameMap) {
        super(gameMap);
        this.pathFinder = pathFinder;
    }

    @Override
    public void create() {
        int rabbitCount = 0;
        while (rabbitCount<5) {
            Coordinate coordinate = new Coordinate(random.nextInt(GRID_ROW), random.nextInt(GRID_COL));
            if (gameMap.isEmpty(coordinate)) {
                gameMap.putEntity(coordinate,new Wolf(coordinate,gameMap,pathFinder));
                rabbitCount++;
            }
        }
    }
}
