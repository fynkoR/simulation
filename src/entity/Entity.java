package entity;


public abstract class Entity {
    private String icon;
    public Entity(String icon){
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "icon='" + icon + '\'' +
                '}';
    }
}
