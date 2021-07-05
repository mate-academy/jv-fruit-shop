package core.basesyntax.dto;

public class Transaction {
    private Operation operation;
    private String name;
    private int quantity;

    public Transaction(Operation operation, String name, int quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
     B, S, P, R
    }
}
