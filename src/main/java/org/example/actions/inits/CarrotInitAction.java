package org.example.actions.inits;

import org.example.GameMap;
import org.example.abstraction.Coordinate;
import org.example.actions.InitAction;
import org.example.dynamic_entity.Carrot;

import java.util.Random;

import static org.example.Constants.GRID_COL;
import static org.example.Constants.GRID_ROW;

public class CarrotInitAction extends InitAction {

    public CarrotInitAction(GameMap gameMap) {
        super(gameMap);
    }

    @Override
    public void create() {
        int carrotCounts = 0;
        while (carrotCounts<=8) {
            Coordinate coordinate = new Coordinate(random.nextInt(GRID_ROW), random.nextInt(GRID_COL));
            if (gameMap.isEmpty(coordinate)) {
                gameMap.putEntity(coordinate,new Carrot(coordinate));
                carrotCounts++;
            }
        }
    }
}
