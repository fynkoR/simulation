package entity;

import enums.EntityType;

public class Tree extends Entity{
    public Tree(int row, int col, String icon) {
        super(row, col, icon, EntityType.TREE);
    }
}
