package org.example;

import org.example.actions.InitAction;
import org.example.actions.TurnAction;
import org.example.actions.inits.*;
import org.example.actions.turns.CreatureTurn;

import java.util.List;

public class Simulation {

    GameMap gameMap = new GameMap();
    PathFinder pathFinder = new PathFinder(gameMap);
    Renderer renderer = new Renderer();

    List<InitAction> initActions = List.of(
            new WolfInit(pathFinder, gameMap),
            new RabbitInit(pathFinder, gameMap),
            new CarrotInit(gameMap),
            new RockInit(gameMap),
            new TreeInit(gameMap)
    );

    List<TurnAction> turnActions = List.of(
            new CreatureTurn(gameMap)
    );

}
