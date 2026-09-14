package actions;

import entity.creatures.Creature;
import game.GameMap;

import java.util.List;

public class MoveCreaturesAction extends Action{
    @Override
    public void perform(GameMap map) {
        List<Creature> creatures = map.getEntities().stream()
                .filter(Creature.class::isInstance)
                .map(Creature.class::cast)
                .toList();
        for(Creature creature : creatures){
            creature.makeMove();
        }
    }
}
