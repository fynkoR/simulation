package entity;

import enums.EntityType;

public abstract class Entity {
    private int row;
    private int col;
    private String icon;
    private EntityType typeEntity;
    public Entity(int row, int col, String icon, EntityType typeEntity){
        this.row = row;
        this.col = col;
        this.icon = icon;
        this.typeEntity = typeEntity;
    }
}
