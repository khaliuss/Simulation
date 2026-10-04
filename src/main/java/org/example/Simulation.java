package org.example;

import org.example.abstraction.PathFinder;
import org.example.actions.InitAction;
import org.example.actions.TurnAction;
import org.example.actions.inits.CarrotInitAction;
import org.example.actions.inits.RabbitInitAction;
import org.example.actions.inits.RockInitAction;
import org.example.actions.turns.RabbitTurnAction;

import java.util.List;

public class Simulation {

    GameMap gameMap = new GameMap();
    PathFinder pathFinder = new PathFinder(gameMap);
    Renderer renderer = new Renderer();

    List<InitAction> initActions = List.of(
            new RabbitInitAction(pathFinder, gameMap),
            new CarrotInitAction(gameMap),
            new RockInitAction(gameMap)
    );

    List<TurnAction> turnActions = List.of(
            new RabbitTurnAction(gameMap)
    );

}
