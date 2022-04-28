package core.basesyntax.model;

public class LineInformation {
    private Integer quantity;
    private String dailyAction;
    private String fruitName;

    public LineInformation(String dailyAction, String fruit, Integer quantity) {
        this.quantity = quantity;
        this.dailyAction = dailyAction;
        this.fruitName = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDailyAction() {
        return dailyAction;
    }

    public void setDailyAction(String dailyAction) {
        this.dailyAction = dailyAction;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
}
