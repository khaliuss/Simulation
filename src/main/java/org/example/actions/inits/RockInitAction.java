package org.example.actions.inits;

import org.example.GameMap;
import org.example.abstraction.Coordinate;
import org.example.actions.InitAction;
import org.example.dynamic_entity.Carrot;
import org.example.static_entity.Rock;

import java.util.Random;

import static org.example.Constants.GRID_COL;
import static org.example.Constants.GRID_ROW;

public class RockInitAction extends InitAction {

    public RockInitAction(GameMap gameMap) {
        super(gameMap);
    }

    @Override
    public void create() {
        int count = 0;
        while (count<=5) {
            Coordinate coordinate = new Coordinate(random.nextInt(GRID_ROW), random.nextInt(GRID_COL));
            if (gameMap.isEmpty(coordinate)) {
                gameMap.putEntity(coordinate,new Rock(coordinate));
                count++;
            }
        }
    }
}
