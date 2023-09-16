package model;

public class FruitTransaction {
    private ActivityType activityType;
    private String name;
    private int quantity;

    public FruitTransaction(ActivityType activityType, String name, int quantity) {
        this.activityType = activityType;
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
