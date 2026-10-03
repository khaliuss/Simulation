package org.example.actions.inits;

import org.example.GameMap;
import org.example.abstraction.Coordinate;
import org.example.actions.InitAction;
import org.example.dynamic_entity.Wolf;

import static org.example.Constants.GRID_COL;
import static org.example.Constants.GRID_ROW;

public class WolfInitAction extends InitAction {

    @Override
    public void create(GameMap gameMap) {
        int wolfCount = 0;
        while (wolfCount<5) {
            Coordinate coordinate = new Coordinate(random.nextInt(GRID_ROW), random.nextInt(GRID_COL));
            if (gameMap.isEmpty(coordinate)) {
                gameMap.putEntity(coordinate,new Wolf(coordinate));
                wolfCount++;
            }
        }
    }
}
