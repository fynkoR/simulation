package entity.objects;


import entity.Entity;

public class Grass extends Entity {
    private int hp;
    public Grass(String icon, int hp) {
        super(icon);
        this.hp = hp;
    }

    public void takeDamage(int damage){
        this.hp -= damage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
