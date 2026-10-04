package org.example.actions.turns;

import org.example.GameMap;
import org.example.abstraction.Creature;
import org.example.actions.TurnAction;

import java.util.List;

public class RabbitTurnAction extends TurnAction {


    public RabbitTurnAction(GameMap gameMap) {
        super(gameMap);
    }

    @Override
    public void makeMove() {
        List<Creature> creatures= gameMap.getCreatures();
        for (Creature creature : creatures){
            creature.makeMove();
        }
    }
}
