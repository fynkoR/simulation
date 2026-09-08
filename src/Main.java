import entity.*;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(10,10);

        Tree tree = new Tree("\uD83C\uDF32");
        Rock rock = new Rock("\uD83E\uDEA8");
        Grass grass = new Grass("\uD83C\uDF3F");
        Herbivore herbivore = new Herbivore("\uD83D\uDC04", 3, 10);
        Predator predator = new Predator("\uD83E\uDD81", 5, 15, 5);

        map.addEntity(new Position(2,4), tree);
        map.addEntity(new Position(3,1), rock);
        map.addEntity(new Position(2,2), grass);
        map.addEntity(new Position(4,2), herbivore);
        map.addEntity(new Position(1,1), predator);

        RenderMap renderMap = new RenderMap(map.getHeight(), map.getWidth());

        renderMap.render(map);

        System.out.println();

        System.out.println(map.getNeighbors(new Position(0,0)));

        PathFinder pathFinder = new PathFinder();
        System.out.println(pathFinder.bfs(map, new Position(0,0), new Position(1,4)));
    }
}