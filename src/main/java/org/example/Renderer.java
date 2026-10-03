package org.example;

import org.example.abstraction.Coordinate;

import static org.example.Constants.GRID_COL;
import static org.example.Constants.GRID_ROW;

public class Renderer {

    public void render(GameMap gameMap){
        for (int row = GRID_ROW; row >= 0; row--) {
            String line = "";
            for (int colum = 0; colum < GRID_COL ; colum++) {
                Coordinate coordinate = new Coordinate(row,colum);
                if (gameMap.isEmpty(coordinate)) {
                    line+="::";
                }else {
                    line+= gameMap.getEntity(coordinate);
                }
            }
            System.out.println(line);
        }
    }

}
