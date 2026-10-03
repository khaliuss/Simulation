package org.example;

import org.example.actions.*;
import org.example.actions.inits.CarrotInitAction;
import org.example.actions.inits.RabbitInitAction;
import org.example.actions.inits.RockInitAction;
import org.example.actions.inits.WolfInitAction;
import org.example.actions.turns.RabbitTurnAction;
import org.example.actions.turns.WolfTurnAction;

import java.util.List;

public class Simulation {

    GameMap gameMap = new GameMap();
    Renderer renderer = new Renderer();
    List<InitAction> initActions = List.of(
      new RabbitInitAction(),
      new WolfInitAction(),
      new CarrotInitAction(),
      new RockInitAction()
    );

    List<TurnAction> turnActions = List.of(
            new RabbitTurnAction(),
            new WolfTurnAction()
    );

}
