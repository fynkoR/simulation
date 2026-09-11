package entity.actions;

import entity.objects.Rock;
import game.GameMap;
import game.Position;

import java.util.Random;

public class TreeSpawnAction implements Action{
    private int count;
    Random random;
    public TreeSpawnAction(){
        random = new Random();
    }
    @Override
    public void perform(GameMap map) {
        if(map.getSize() >= 10){
            this.count = map.getSize() / 5;
        }
        else{
            this.count = 1;
        }
        for(int i = 0; i < count; i++){
            int attemptMax = map.getSize() * map.getSize();
            for(int j = 0; j < attemptMax; j++){
                Position position = new Position(random.nextInt(0, map.getSize()), random.nextInt(0, map.getSize()));
                if(map.isEmpty(position)){
                    map.addEntity(position, new Rock("\uD83C\uDF32"));
                    break;
                }
            }
        }
    }
}
