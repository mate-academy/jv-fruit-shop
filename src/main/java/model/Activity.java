package model;

public class Activity {
    private final ActivityType type;
    private final String fruit;
    private final int quantity;

    public Activity(ActivityType type, String fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public ActivityType getType() {
        return type;
    }
}
