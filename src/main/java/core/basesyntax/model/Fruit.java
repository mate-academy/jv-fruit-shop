package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;
    private int quantity;

    public Fruit() {
    }

    public Fruit(String name) {
        this.name = name;
    }

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object fruit) {
        if (this == fruit) {
            return true;
        }
        if (fruit == null || getClass() != fruit.getClass()) {
            return false;
        }

        Fruit thatFruit = (Fruit) fruit;
        return (thatFruit.name == this.name
                || (thatFruit.name != null && thatFruit.name.equals(this.name)))
                && thatFruit.quantity == this.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }
}
