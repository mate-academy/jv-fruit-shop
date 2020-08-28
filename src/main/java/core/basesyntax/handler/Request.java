package core.basesyntax.handler;

import core.basesyntax.model.Fruit;

public class Request {
    private String actionType;
    private int quantity;
    private Fruit fruit;

    public Request(String actionType, int quantity, Fruit fruit) {
        this.actionType = actionType;
        this.quantity = quantity;
        this.fruit = fruit;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }
}
