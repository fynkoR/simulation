package entity.actions;

import entity.Entity;
import entity.objects.Rock;
import game.GameMap;
import game.Position;

import java.util.Random;

public abstract class SpawnAction implements Action{
    public Random random;
    @Override
    public void perform(GameMap map) {
        random = new Random();
        for(int i = 0; i < getCount(); i++){
            int attemptMax = map.getSize() * map.getSize();
            for(int j = 0; j < attemptMax; j++){
                Position position = new Position(random.nextInt(0, map.getSize()), random.nextInt(0, map.getSize()));
                if(map.isEmpty(position)){
                    map.addEntity(position, createEntity());
                    break;
                }
            }
        }
    }

    public abstract int getCount();
    public abstract Entity createEntity();
}
