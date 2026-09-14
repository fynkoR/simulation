package actions;

import entity.Entity;
import entity.creatures.Herbivore;
import entity.objects.Grass;
import game.GameMap;
import game.Position;

import java.util.HashMap;

public class GrassSpawnAction extends SpawnAction{
    private final int count;
    private final String icon;
    private final int hp;
    public GrassSpawnAction(int size){
        this.icon = "\uD83C\uDF3F";
        this.hp = 4;

        if(size >= 10){
            count = size / 5;
        }
        else{
            count = 1;
        }
    }

    @Override
    public void perform(GameMap map) {
        int current = 0;
        HashMap<Position, Entity> entities = map.getMap();
        for(Position position : entities.keySet()){
            if(entities.get(position) instanceof Grass){
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
        return new Grass(icon, hp);
    }
}
