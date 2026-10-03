package org.example.actions;

import org.example.GameMap;

import java.util.Random;

public abstract class InitAction extends Action {

    protected Random random = new Random();

    public abstract void create(GameMap gameMap);
}
