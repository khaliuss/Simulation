package org.example;

import org.example.actions.InitAction;
import org.example.actions.TurnAction;
import org.example.actions.inits.*;
import org.example.actions.turns.CreatureTurn;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class Simulation {

    private GameMap gameMap = new GameMap();
    private PathFinder pathFinder = new PathFinder(gameMap);
    private Renderer renderer = new Renderer();

    private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(5);
    private final AtomicBoolean isPaused = new AtomicBoolean();
    private final Object monitor = new Object();
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
        executorService.submit(() -> {
            queue.add(task());
        });

        try {
            executorService.submit(queue.take());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Runnable task() {
        return () -> {
            System.out.print("\033[H\033[2J");
            renderer.render(gameMap);

            for (TurnAction action : turnActions) {
                action.makeMove();
            }
            moveCounter++;
        };
    }


    public void startSimulation() {
        synchronized (monitor) {
            isPaused.set(false);
            monitor.notifyAll();
        }


        executorService.submit(() -> {
            while (true) {
                synchronized (monitor) {
                    if (isPaused.get()) {
                        monitor.wait();
                    }
                }
                nextTurn();
            }
        });
    }


    public void pauseSimulation(boolean pause) {
        isPaused.set(pause);
    }

}