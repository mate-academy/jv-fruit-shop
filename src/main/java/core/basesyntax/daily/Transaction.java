package core.basesyntax.daily;

import java.time.LocalDate;

public class Transaction {
    private Character operation;
    private String fruitType;
    private int quantity;
    private LocalDate transactionDate;

    public void setOperation(Character operation) {
        this.operation = operation;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Character getOperation() {
        return operation;
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}
