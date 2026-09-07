package entity;

import enums.EntityType;

public class Grass extends Entity{
    public Grass(int row, int col, String icon) {
        super(row, col, icon, EntityType.GRASS);
    }
}
