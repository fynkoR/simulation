package game;

import entity.Entity;
import entity.creatures.Creature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameMap {
    private HashMap<Position, Entity> map;
    private int size;

    public GameMap(int size) {
        map = new HashMap<>();
        this.size = size;
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

    public boolean isEmpty(Position position){
        return !map.containsKey(position);
    }

    public HashMap<Position, Entity> getMap() {
        return map;
    }

    public void moveEntity(Position position, Creature creature){
        map.remove(getKeyByValue(creature));
        map.put(position, creature);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
            if (neighbor.getX() >= 0 && neighbor.getX() < size
                    && neighbor.getY() >= 0 && neighbor.getY() < size) {
                arr.add(neighbor);
            }
        }
        return arr;

    }
    public <T extends Entity> HashMap<Position, T> getEntityByClass(Class<T> objClass){
        HashMap<Position, T> entities = new HashMap<>();
        for(Map.Entry <Position, Entity> e : map.entrySet()){
            if(objClass.isInstance(e.getValue())){
                Map.Entry<Position,T> entry = (Map.Entry<Position, T>) e;
                entities.put(entry.getKey(), entry.getValue());
            }
        }
        return entities;
    }
    public Position getKeyByValue(Entity entity){
        for(Map.Entry<Position, Entity> e : map.entrySet()){
            if(entity.equals(e.getValue())){
                return e.getKey();
            }
        }
        return null;
    }
}
