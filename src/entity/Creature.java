package entity;

import enums.EntityType;

public abstract class Creature extends Entity{
    private int speed;
    private int hp;

    public Creature(int row, int col, String icon, EntityType typeEntity) {
        super(row, col, icon, typeEntity);
    }

    void makeMove(){}
}
