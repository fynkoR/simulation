import entity.actions.RockSpawnAction;
import entity.creatures.Herbivore;
import entity.creatures.Predator;
import game.GameMap;
import game.PathFinder;
import game.Position;
import game.RenderMap;
import entity.objects.Grass;
import entity.objects.Rock;
import entity.objects.Tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        GameMap gameMap = new GameMap(10);

        Tree tree = new Tree("\uD83C\uDF32");


        /*RockSpawnAction rockSpawnAction = new RockSpawnAction();
        rockSpawnAction.perform(gameMap);*/


        //Rock rock = new Rock("\uD83E\uDEA8");


        Grass grass = new Grass("\uD83C\uDF3F", 4);
        Herbivore herbivore = new Herbivore("\uD83D\uDC04",gameMap, 3, 10, 2);
        Predator predator = new Predator("\uD83E\uDD81",gameMap, 3, 15, 5);

        gameMap.addEntity(new Position(2,4), tree);
        //gameMap.addEntity(new Position(3,1), rock);
        gameMap.addEntity(new Position(2,2), grass);
        gameMap.addEntity(new Position(4,2), herbivore);
        gameMap.addEntity(new Position(1,1), predator);

        RenderMap renderMap = new RenderMap(gameMap.getSize());

        renderMap.render(gameMap);

/*        System.out.println();

        Set<Position> targets = gameMap.getEntityByClass(predator.getTargetType()).keySet();
        System.out.println(targets);

        List<Position> path = PathFinder.bfs(gameMap, gameMap.getKeyByValue(predator), targets.stream().toList().getFirst());
        System.out.println(path);*/

        System.out.println(herbivore.getHp());

        predator.makeMove();
        herbivore.makeMove();
        System.out.println(herbivore.getHp());

        renderMap.render(gameMap);

        predator.makeMove();
        herbivore.makeMove();
        System.out.println(herbivore.getHp());

        renderMap.render(gameMap);


    }

}