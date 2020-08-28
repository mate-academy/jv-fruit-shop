package core.basesyntax.daily;

import java.time.LocalDate;

public class Transaction {
    private Character operation;
    private String fruitName;
    private int quantity;
    private LocalDate transactionDate;

    public void setOperation(Character operation) {
        this.operation = operation;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
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

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}
