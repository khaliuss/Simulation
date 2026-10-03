package org.example.actions;

import org.example.GameMap;
import org.example.PathFinder;
import org.example.abstraction.Coordinate;

public abstract class TurnAction extends Action {
    public abstract void makeMove(GameMap map,PathFinder pathFinder);
}
