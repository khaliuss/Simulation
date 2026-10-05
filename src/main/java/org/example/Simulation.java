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
    private int moveCounter = 0;

    private final List<InitAction> initActions = List.of(
            new RabbitInit(pathFinder, gameMap),
            new WolfInit(pathFinder, gameMap),
            new CarrotInit(gameMap),
            new RockInit(gameMap),
            new TreeInit(gameMap)
    );

    private final List<TurnAction> turnActions = List.of(
            new CreatureTurn(gameMap)
    );

    public void creat() {
        for (InitAction action : initActions) {
            action.create();
        }
    }

    public void nextTurn() {
        System.out.print("\033[H\033[2J");
        renderer.render(gameMap);
        System.out.println();
        for (TurnAction action : turnActions) {
            action.makeMove();
        }
        moveCounter++;
    }



    public void startSimulation() {
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            nextTurn();
        }
    }

    public void pauseSimulation() {
        System.exit(0);
    }


}
