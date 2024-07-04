package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String fruitName;
    private int quantity;

    private Fruit(String fruitName, int quantity) {
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public static Fruit of(String fruitName, int quantity) {
        return new Fruit(fruitName, quantity);
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
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
        return quantity == fruit.quantity && Objects.equals(fruitName, fruit.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName, quantity);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "fruit='" + fruitName + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
