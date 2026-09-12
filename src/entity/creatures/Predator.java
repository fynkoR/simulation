package entity.creatures;

import entity.Entity;
import game.GameMap;
import game.Position;

public class Predator extends Creature {

    public Predator(String icon, GameMap map){
        super(icon, map);
    }

    public Predator(String icon, GameMap map, int speed, int hp, int damage) {
        super(icon, map);
        this.damage = damage;
        this.speed = speed;
    }

    @Override
    public void makeMove() {
        super.makeMove();
    }

    @Override
    public void attack(Position position, int damage) {
        Herbivore herbivore = (Herbivore) map.findEntity(position);
        herbivore.takeDamage(damage);
        if(herbivore.getHp() < 0){
            herbivore.isAlive = false;
            map.deleteEntity(position);
            map.moveEntity(position, this);
        }
    }

    @Override
    public Class<? extends Entity> getTargetType() {
        return Herbivore.class;
    }
}
