package actions;

import entity.Entity;
import entity.objects.Tree;

public class TreeSpawnAction extends SpawnAction {
    private final int count;
    private final String icon;
    public TreeSpawnAction(int size){
        this.icon = "\uD83C\uDF33";
        if(size >= 10){
            this.count = size / 5;
        }
        else{
            count =1;
        }
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public Entity createEntity() {
        return new Tree(icon);
    }
}
