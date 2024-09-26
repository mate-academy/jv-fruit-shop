package core.basesyntax.model;

public class FruitTransaction {
    private Action action;
    private String fruit;
    private int value;

    public FruitTransaction(Action action, String fruit, int value) {
        this.action = action;
        this.fruit = fruit;
        this.value = value;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
