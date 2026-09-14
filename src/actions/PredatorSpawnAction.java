package actions;

import entity.Entity;
import entity.creatures.Predator;
import game.GameMap;

public class PredatorSpawnAction extends SpawnAction{
    private final int count;
    private final String icon;
    private final GameMap map;
    public PredatorSpawnAction(GameMap map){
        this.icon = "\uD83E\uDD81";
        int size = map.getSize();
        if(size >= 10){
            this.count = size / 10;
        }
        else{
            this.count = 1;
        }
        this.map = map;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public Entity createEntity() {
        return new Predator(icon, map, 3, 15, 5);
    }
}
