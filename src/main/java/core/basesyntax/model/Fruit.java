package core.basesyntax.model;

import java.io.Serializable;
import java.util.Objects;

public class Fruit implements Serializable {
    private String fruitType;
    private int quantity;

    public Fruit(String fruitType, int amount) {
        this.fruitType = fruitType;
        this.quantity = amount;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruit) {
        this.fruitType = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object fruit) {
        if (this == fruit) {
            return true;
        }
        if (fruit == null) {
            return false;
        }
        if (getClass().equals(fruit.getClass())) {
            Fruit current = (Fruit) fruit;
            return quantity == current.quantity
                    && Objects.equals(this.fruitType, current.fruitType);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitType, quantity);
    }

    @Override
    public String toString() {
        return fruitType + "," + quantity + System.lineSeparator();
    }
}
