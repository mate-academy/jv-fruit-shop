package core.basesyntax.model;

import java.util.NoSuchElementException;

public class Transaction {
    private Operation operation;
    private String fruitName;
    private int quantity;

    public Transaction(String operation, String fruitName, int quantity) {
        this.operation = parseToOperation(operation);
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private Operation parseToOperation(String operation) {
        switch (operation) {
            case "b": return Operation.BALANCE;
            case "s": return Operation.SUPPLY;
            case "p": return Operation.PURCHASE;
            case "r": return Operation.RETURN;
            default: throw new NoSuchElementException("Operation " + operation + " doesn't exist");
        }
    }
}
