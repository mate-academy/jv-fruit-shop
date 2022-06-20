package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String operation;
    private String name;
    private Integer quantity;

    public Fruit(String operation, String name, Integer quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
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
        return Objects.equals(operation, fruit.operation)
                && Objects.equals(name, fruit.name) && Objects.equals(quantity, fruit.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, name, quantity);
    }
}
