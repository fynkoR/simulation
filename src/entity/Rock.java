package entity;

import enums.EntityType;

public class Rock extends Entity {
    public Rock(int row, int col, String icon) {
        super(row, col, icon, EntityType.ROCK);
    }
}
