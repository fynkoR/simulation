package entity.actions;

import entity.Entity;
import entity.creatures.Herbivore;
import game.GameMap;

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
    public int getCount() {
        return this.count;
    }

    @Override
    public Entity createEntity() {
        return new Herbivore(icon, map, 3, 10, 2);
    }
}
