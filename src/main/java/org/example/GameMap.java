package org.example;

import org.example.abstraction.Coordinate;
import org.example.abstraction.Creature;
import org.example.abstraction.Entity;
import org.example.actions.inits.CarrotInitAction;
import org.example.dynamic_entity.Carrot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameMap {

    private HashMap<Coordinate, Entity> entities = new HashMap();


    public HashMap<Coordinate, Entity> getEntities() {
        return entities;
    }

    public List<Creature> getCreatures() {
        List<Creature> creatures = new ArrayList<>();
        for (Entity entity : entities.values()){
            if (entity instanceof Creature creature){
                creatures.add(creature);
            }
        }
        return creatures;
    }

    public void putEntity(Coordinate coordinate, Entity entity) {
        entities.put(coordinate, entity);
    }

    public Entity getEntity(Coordinate coordinate) {
        return entities.get(coordinate);
    }

    public void deleteEntity(Coordinate coordinate) {
        if (carrotAmount() < 1){
            new CarrotInitAction(this).create();
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
