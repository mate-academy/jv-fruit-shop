package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String fruitName;
    private int quantity;

    public Fruit(String fruitName, int quantity) {
        this.fruitName = fruitName;
        this.quantity = quantity;
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
        return fruitName + "," + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit1 = (Fruit) o;
        return quantity == fruit1.quantity && Objects.equals(fruitName, fruit1.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName);
    }
}
