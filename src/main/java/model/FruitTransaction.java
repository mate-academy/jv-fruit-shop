package model;

public class FruitTransaction {
    private ActivityType activityType;
    private Fruit fruit;
    private Integer amount;

    public FruitTransaction(ActivityType activityType, Fruit fruit, Integer amount) {
        this.activityType = activityType;
        this.fruit = fruit;
        this.amount = amount;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
