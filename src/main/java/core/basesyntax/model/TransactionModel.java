package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public class TransactionModel extends Model {
    private String name;
    private String operation;
    private LocalDate date;
    private int amount;

    public TransactionModel(String name, String operation, LocalDate date, int amount) {
        this.name = name;
        this.operation = operation;
        this.date = date;
        this.amount = amount;
    }

    public TransactionModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionModel that = (TransactionModel) o;
        return amount == that.amount
                && Objects.equals(name, that.name)
                && Objects.equals(operation, that.operation)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, operation, date, amount);
    }
}
