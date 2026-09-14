package actions;

import entity.Entity;
import entity.creatures.Herbivore;
import game.GameMap;
import game.Position;

import java.util.HashMap;

public class HerbivoreSpawnAction extends SpawnAction{
    private final int count;
    private final String icon;
    private final GameMap map;
    public HerbivoreSpawnAction(GameMap map){
        this.icon = "\uD83D\uDC04";
        int size = map.getSize();
        this.map = map;
        if(size >= 10){
            this.count = size / 5;
        }
        else{
            this.count = 1;
        }
    }


    @Override
    public void perform(GameMap map) {
        int current = 0;
        HashMap<Position, Entity> entities = map.getMap();
        for(Position position : entities.keySet()){
            if(entities.get(position) instanceof Herbivore){
                current++;
            }
        }

        while(current < getCount()){
            Position position = getEmptyRandomPosition(map);
            map.addEntity(position, createEntity());
            current++;
        }
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public Entity createEntity() {
        return new Herbivore(icon, map, 2, 10, 2);
    }
}
