package org.example;

import org.example.abstraction.Coordinate;
import org.example.abstraction.Entity;
import org.example.actions.inits.CarrotInitAction;
import org.example.dynamic_entity.Carrot;

import java.util.HashMap;

public class GameMap {

    private HashMap<Coordinate, Entity> entities = new HashMap();


    public HashMap<Coordinate, Entity> getEntities() {
        return entities;
    }

    public void putEntity(Coordinate coordinate, Entity entity) {
        entities.put(coordinate, entity);
    }

    public Entity getEntity(Coordinate coordinate) {
        return entities.get(coordinate);
    }

    public void deleteEntity(Coordinate coordinate) {
        if (carrotAmount() < 1){
            new CarrotInitAction().create(this);
        }
        entities.remove(coordinate);
    }

    private int carrotAmount() {
        int count = 0;
        for (Entity entity : entities.values()){
            if (entity instanceof Carrot){
                count++;
            }
        }
        return count;
    }

    public boolean isEmpty(Coordinate coordinate) {
        return !entities.containsKey(coordinate);
    }


}
