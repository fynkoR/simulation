package actions;

import entity.Entity;
import game.GameMap;
import game.Position;

import java.util.Random;

public abstract class SpawnAction extends Action{
    public Random random;
    @Override
    public void perform(GameMap map) {
        map.addEntity(getEmptyRandomPosition(map), createEntity());
    }

    public Position getEmptyRandomPosition(GameMap map){
        random = new Random();
        for(int i = 0; i < getCount(); i++){
            int attemptMax = map.getSize() * map.getSize();
            for(int j = 0; j < attemptMax; j++){
                Position position = new Position(random.nextInt(0, map.getSize()), random.nextInt(0, map.getSize()));
                if(map.isEmpty(position)){
                    return position;
                }
            }
        }
        return null;
    }

    public abstract int getCount();
    public abstract Entity createEntity();
}
