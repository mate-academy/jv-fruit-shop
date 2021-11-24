package core.basesyntax.model;

import java.util.Objects;

public class TransactionDto {
    private String operation;
    private String name;
    private int quantity;

    public TransactionDto(String operation, String name, int quantity) {
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

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDto that = (TransactionDto) o;
        return quantity == that.quantity && Objects.equals(operation, that.operation) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, name, quantity);
    }

    @Override
    public String toString() {
        return "TransactionDto{ operation='" + operation + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
