package core.basesyntax.handler;

import core.basesyntax.model.Fruit;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Request request = (Request) o;
        return quantity == request.quantity
                && Objects.equals(actionType, request.actionType)
                && Objects.equals(fruit, request.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionType, quantity, fruit);
    }

    @Override
    public String toString() {
        return "Request{"
                + "actionType='" + actionType + '\''
                + ", quantity=" + quantity
                + ", fruit=" + fruit
                + '}';
    }
}
