import entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    private HashMap<Position, Entity> map;
    private int width; // ширина
    private int height; // высота

    public Map(int height, int width) {
        map = new HashMap<>();
        this.height = height;
        this.width = width;
    }

    public void addEntity(Position position, Entity entity) {
        if (!map.containsKey(position)) {
            map.put(position, entity);
        } else {
            System.out.println("Данная клетка занята !");
        }
    }


    public void deleteEntity(Position position) {
        map.remove(position);
    }

    public Entity findEntity(Position position) {
        return map.get(position);
    }

    public HashMap<Position, Entity> getMap() {
        return map;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Position> getNeighbors(Position pos) {
        List<Position> arr = new ArrayList<>();

        List<Position> neighbors = List.of(
                new Position(pos.getX() + 1, pos.getY()),
                new Position(pos.getX() - 1, pos.getY()),
                new Position(pos.getX(), pos.getY() - 1),
                new Position(pos.getX(), pos.getY() + 1)
        );
        for (Position neighbor : neighbors) {
            if (neighbor.getX() >= 0 && neighbor.getX() < width
                    && neighbor.getY() >= 0 && neighbor.getY() < height) {
                arr.add(neighbor);
            }
        }
        return arr;

    }

}
