package core.basesyntax.model;

import java.util.Objects;

public abstract class Fruit {
    private String name;
    private int quantity;

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return quantity == fruit.quantity && Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "name='" + name + '\''
                + ", quantity=" + quantity + '}';
    }
}
