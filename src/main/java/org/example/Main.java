package org.example;

import org.example.actions.InitAction;
import org.example.actions.TurnAction;

import java.util.Random;

public class Main {

    static void main() {
        Simulation simulation = new Simulation();

        PathFinder pathFinder = new PathFinder(simulation.gameMap);
        for (InitAction action : simulation.initActions) {
            action.create(simulation.gameMap);
        }

        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("\033[H\033[2J");
            simulation.renderer.render(simulation.gameMap);
            System.out.println();
            for (TurnAction action : simulation.turnActions) {
                action.makeMove(simulation.gameMap, pathFinder);
            }
        }


    }

}
