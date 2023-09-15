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

    public FruitTransaction(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
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
        FruitTransaction fruitTransaction = (FruitTransaction) o;
        return quantity == fruitTransaction.quantity && operation == fruitTransaction.operation
                && Objects.equals(name, fruitTransaction.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, name, quantity);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "operation='" + operation + '\''
                + ", name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
