package core.shop.model;

public class FruitRecord {
    private ActivityType activityType;
    private String fruitName;
    private int quantity;

    public FruitRecord() {

    }

    public FruitRecord(ActivityType activityType, String fruitName, int quantity) {
        this.activityType = activityType;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FruitRecord{"
                + "activityType=" + activityType
                + ", fruitName='" + fruitName + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
