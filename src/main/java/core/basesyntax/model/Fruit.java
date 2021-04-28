package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private Type actionType;
    private String fruitName;
    private int quantity;

    public Type getActionType() {
        return actionType;
    }

    public void setActionType(Type actionType) {
        this.actionType = actionType;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Fruit fruit = (Fruit) o;

        if (quantity != fruit.quantity) {
            return false;
        }
        if (actionType != fruit.actionType) {
            return false;
        }
        return Objects.equals(fruitName, fruit.fruitName);
    }

    @Override
    public int hashCode() {
        int result = actionType != null ? actionType.hashCode() : 0;
        result = 31 * result + (fruitName != null ? fruitName.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }

    public enum Type {
        b, r, s, p;
    }
}
