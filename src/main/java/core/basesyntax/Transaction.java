package core.basesyntax;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private String operation;
    private String fruitName;
    private int quantity;
    private LocalDate date;

    public Transaction(String operation, String fruitName, int quantity, LocalDate date) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction that = (Transaction) o;
        return quantity == that.quantity
                && Objects.equals(operation, that.operation)
                && Objects.equals(fruitName, that.fruitName)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruitName, quantity, date);
    }
}
