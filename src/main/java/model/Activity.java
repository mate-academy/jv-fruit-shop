package model;

public class Activity {
    private ActivityType type;
    private String fruit;
    private int quantity;

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
