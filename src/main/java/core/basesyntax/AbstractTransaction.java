package core.basesyntax;

import java.time.LocalDate;
import java.util.Objects;

public abstract class AbstractTransaction {
    private String transactionType;
    private String fruitType;
    private int quantity;
    private LocalDate date;

    public AbstractTransaction(String transactionType) {
        this.transactionType = transactionType;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTransactionType() {
        return transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractTransaction abstractTransaction = (AbstractTransaction) o;
        return Objects.equals(transactionType, abstractTransaction.transactionType)
                && Objects.equals(fruitType, abstractTransaction.fruitType)
                && quantity == abstractTransaction.quantity
                && Objects.equals(date, abstractTransaction.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionType, fruitType, quantity, date);
    }
}
