package core.basesyntax.model;

public class DailyActivity {
    private Integer amount;
    private String activityType;
    private String fruitName;

    public DailyActivity(Integer amount, String activityType, String fruitName) {
        this.amount = amount;
        this.activityType = activityType;
        this.fruitName = fruitName;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getActivityType() {
        return activityType;
    }

    public String getFruitName() {
        return fruitName;
    }

}
