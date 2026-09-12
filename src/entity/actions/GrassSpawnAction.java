package entity.actions;

import entity.Entity;
import entity.objects.Grass;

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
    public int getCount() {
        return this.count;
    }

    @Override
    public Entity createEntity() {
        return new Grass(icon, hp);
    }
}
