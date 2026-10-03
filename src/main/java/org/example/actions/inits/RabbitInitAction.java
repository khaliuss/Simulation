package org.example.actions.inits;

import org.example.GameMap;
import org.example.abstraction.Coordinate;
import org.example.actions.InitAction;
import org.example.dynamic_entity.Rabbit;

import java.util.Random;

import static org.example.Constants.GRID_COL;
import static org.example.Constants.GRID_ROW;

public class RabbitInitAction extends InitAction {

    @Override
    public void create(GameMap gameMap) {
        int rabbitCount = 0;
        while (rabbitCount<5) {
            Coordinate coordinate = new Coordinate(random.nextInt(GRID_ROW), random.nextInt(GRID_COL));
            if (gameMap.isEmpty(coordinate)) {
                gameMap.putEntity(coordinate,new Rabbit(coordinate));
                rabbitCount++;
            }
        }
    }
}
