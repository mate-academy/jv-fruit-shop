package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private final String name;
    private Integer quantity;

    public Fruit(String name) {
        this.name = name;
    }

    public Fruit(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
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

    @Override
    public String toString() {
        return "Fruit{"
                + "name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
