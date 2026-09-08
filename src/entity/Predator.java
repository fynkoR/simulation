package entity;

import java.util.Map;

public class Predator extends Creature{
    private int damage;

    public Predator(String icon, int speed, int hp, int damage) {
        super(icon, speed, hp);
        this.damage = damage;
    }

    @Override
    void makeMove() {
        super.makeMove();
    }
}
