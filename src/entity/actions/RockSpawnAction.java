package entity.actions;

import entity.Entity;
import entity.objects.Rock;

public class RockSpawnAction extends SpawnAction{
    private final int count;
    public RockSpawnAction(int size){
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
        return new Rock("\uD83E\uDEA8");
    }
}
