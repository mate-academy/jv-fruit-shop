package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String operation;
    private String name;
    private int quantity;

    public Fruit(String operation, String name, int quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Fruit fruit = (Fruit) obj;

        if (quantity != fruit.quantity) {
            return false;
        }
        if (!Objects.equals(name, fruit.name)) {
            return false;
        }
        return Objects.equals(operation, fruit.operation);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + quantity;
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }
}
