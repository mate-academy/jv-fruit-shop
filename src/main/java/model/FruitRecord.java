package model;

public class FruitRecord {
    private final String activityType;
    private final String fruitName;
    private final int amount;

    public FruitRecord(String activityType, String fruitName, int amount) {
        this.activityType = activityType;
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public String getActivityType() {
        return activityType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }
}
