package org.example.actions;

import org.example.GameMap;

public abstract class TurnAction extends Action {

    protected final GameMap gameMap;

    protected TurnAction(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public abstract void makeMove();
}
