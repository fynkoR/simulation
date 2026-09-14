package game;

import entity.Entity;
import entity.creatures.Creature;

import java.util.*;

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
        RenderMap.render(this);
    }

    public int getSize() {
        return size;
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
    public <T extends Entity> List<Position> getEntitiesByClass(Entity entity, Class<T> objClass){
        Position position = getKeyByValue(entity);
        List<Position> entities = new ArrayList<>();
        for(Map.Entry <Position, Entity> e : map.entrySet()){
            if(objClass.isInstance(e.getValue())){
                Map.Entry<Position,T> entry = (Map.Entry<Position, T>) e;
                entities.add(entry.getKey());
            }
        }
        if(position != null){
            entities.sort(Comparator.comparingDouble(p -> p.distanceTo(position)));
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

    public List<Entity> getEntities(){
        return new ArrayList<>(map.values());
    }

    public Entity getEntityByPostion(Position position){
        Entity entity = map.get(position);
        return entity;
    }
}
