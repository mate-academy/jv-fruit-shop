package core.basesyntax.model;

import java.util.Objects;

public final class Fruit {
    private final String name;
    private final int quantity;

    private Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public static Fruit of(String name, int quantity) {
        return new Fruit(name, quantity);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
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
        return Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
