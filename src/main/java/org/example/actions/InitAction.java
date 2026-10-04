package org.example.actions;

import org.example.GameMap;


import java.util.Random;

public abstract class InitAction extends Action {

    protected Random random = new Random();
    protected  final GameMap gameMap;

    protected InitAction(GameMap gameMap) {
        this.gameMap = gameMap;
    }


    public abstract void create();
}
