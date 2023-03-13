package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String fruit;
    private int quantity;

    public Fruit(String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit)) return false;
        Fruit fruit1 = (Fruit) o;
        return getQuantity() == fruit1.getQuantity() && getFruit().equals(fruit1.getFruit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFruit(), getQuantity());
    }
}
