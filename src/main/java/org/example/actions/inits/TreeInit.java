package org.example.actions.inits;

import org.example.GameMap;
import org.example.abstraction.Coordinate;
import org.example.actions.InitAction;
import org.example.staticentity.Tree;

import static org.example.Constants.GRID_COL;
import static org.example.Constants.GRID_ROW;

public class TreeInit extends InitAction {

    public TreeInit(GameMap gameMap) {
        super(gameMap);
    }

    @Override
    public void create() {
        int count = 0;
        while (count<10) {
            Coordinate coordinate = new Coordinate(random.nextInt(GRID_ROW), random.nextInt(GRID_COL));
            if (gameMap.isEmpty(coordinate)) {
                gameMap.putEntity(coordinate,new Tree(coordinate));
                count++;
            }
        }
    }
}
