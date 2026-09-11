package entity.creatures;

import entity.Entity;
import entity.objects.Grass;
import game.GameMap;
import game.Position;

public class Herbivore extends Creature {

    public Herbivore(String icon, GameMap map, int speed, int hp, int damage) {
        super(icon, map);
        this.setSpeed(speed);
        this.damage = damage;
        this.hp = hp;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    @Override
    public void makeMove() {
        super.makeMove();
    }

    @Override
    public void attack(Position position, int damage) {
        Grass grass = (Grass) map.findEntity(position);
        grass.takeDamage(damage);
        if (grass.getHp() <= 0) {
            map.deleteEntity(position);
            map.moveEntity(position, this);
        }
    }

    @Override
    Class<? extends Entity> getTargetType() {
        return Grass.class;
    }
}
