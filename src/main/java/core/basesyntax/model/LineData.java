package core.basesyntax.model;

public class LineData {
    private Integer quantity;
    private String action;
    private Fruit fruit;

    public LineData(String dailyAction, Fruit fruit, Integer quantity) {
        this.action = dailyAction;
        this.fruit = fruit;
        this.quantity = quantity;
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

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }
}
