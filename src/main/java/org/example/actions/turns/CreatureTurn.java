package org.example.actions.turns;

import org.example.GameMap;
import org.example.abstraction.Coordinate;
import org.example.abstraction.Creature;
import org.example.actions.TurnAction;

import java.util.List;

public class CreatureTurn extends TurnAction {


    public CreatureTurn(GameMap gameMap) {
        super(gameMap);
    }

    @Override
    public void makeMove() {
        List<Creature> coordinates = gameMap.getCreatures();
        if (coordinates.isEmpty()){
            System.exit(0);
        }
        for (Creature creature : coordinates){
            if (creature.isDead()) continue;
            creature.makeMove();
        }
    }
}
