package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private final String type;
    private Integer quantity;

    public Fruit(String type) {
        this.type = type;
    }

    public Fruit(String type, Integer quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
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
        return Objects.equals(type, fruit.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "type='" + type + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
