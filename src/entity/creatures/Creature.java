package entity.creatures;

import game.GameMap;
import entity.Entity;
import game.PathFinder;
import game.Position;

import java.util.List;
import java.util.Set;


public abstract class Creature extends Entity {
    int speed;
    int hp;
    boolean isAlive;
    GameMap map;
    int damage;


    public Creature(String icon, GameMap map) {
        super(icon);
        isAlive = true;
        this.map = map;
    }

    public void makeMove(){
        Set<Position> targets = map.getEntityByClass(this.getTargetType()).keySet();
        if(isAlive && !targets.isEmpty()){
            List<Position> path = PathFinder.bfs(map, this.map.getKeyByValue(this),
                    targets.stream().toList().getFirst());
            if(!path.isEmpty()){
                if(path.size() == 1){
                    attack(targets.stream().toList().getFirst(), damage);
                    System.out.println(this + " attacked(1): " + targets.stream().toList().getFirst());
                }
                else{
                    for(int i = 0; i < this.getSpeed(); i++){
                        if(i < path.size() - 1){
                            map.moveEntity(path.get(i), this);
                        }
                        else{
                            attack(targets.stream().toList().getFirst(), damage);
                            System.out.println(this + " attacked(2): " + map.findEntity(targets.stream().toList().getFirst()));
                            break;
                        }
                    }
                }
            }
        }
    }

    public abstract void attack(Position position, int damage);

    abstract Class<? extends Entity> getTargetType();

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
