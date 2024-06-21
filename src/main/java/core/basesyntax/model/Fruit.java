package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private static final int DEFAULT_QUANTITY = 0;
    private final String name;
    private int quantity;

    public Fruit(String name) {
        this.name = name;
        this.quantity = DEFAULT_QUANTITY;
    }

    public String getName() {
        return name;
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
        return Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
