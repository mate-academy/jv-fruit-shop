package model;

import java.util.Objects;

public class FruitTransaction {
    private String operation;
    private String name;
    private int quantity;

    public FruitTransaction(String operation, String name, int quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
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
    public int hashCode() {
        return Objects.hash(operation, name, quantity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FruitTransaction other = (FruitTransaction) obj;
        return quantity == other.quantity
                && Objects.equals(operation, other.operation)
                && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "Fruits"
                + "operation="
                + operation
                + ", name='"
                + name + '\''
                + ", quantity="
                + quantity
                + '}';
    }
}
