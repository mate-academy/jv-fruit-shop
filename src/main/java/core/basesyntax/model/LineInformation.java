package core.basesyntax.model;

public class LineInformation {
    private Integer quantity;
    private String action;
    private String fruitName;

    public LineInformation(String action, String fruit, Integer quantity) {
        this.quantity = quantity;
        this.action = action;
        this.fruitName = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
}
