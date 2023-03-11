package model;

public class Record {
    private final String activityType;
    private final String fruitName;
    private final int fruitAmount;

    public Record(String activityType, String fruitName, int fruitAmount) {
        this.activityType = activityType;
        this.fruitName = fruitName;
        this.fruitAmount = fruitAmount;
    }

    public String getActivityType() {
        return activityType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getFruitAmount() {
        return fruitAmount;
    }
}
