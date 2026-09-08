package entity;


public abstract class Creature extends Entity{
    private int speed;
    private int hp;

    public Creature(String icon, int speed, int hp) {
        super(icon);
        this.speed = speed;
        this.hp = hp;
    }

    void makeMove(){}
}
