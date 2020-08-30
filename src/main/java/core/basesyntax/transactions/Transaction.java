package core.basesyntax.transactions;

import java.time.LocalDate;

public class Transaction {
    private String operation;
    private String fruitType;
    private int quantity;
    private LocalDate expirationDate;
    private Transaction transaction;

    public Transaction(String operation, String fruitType, int quantity, LocalDate expirationDate) {
        this.operation = operation;
        this.fruitType = fruitType;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "\n" + operation + ","
                + fruitType + ","
                + quantity + ","
                + expirationDate;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
