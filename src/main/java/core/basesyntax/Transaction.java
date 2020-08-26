package core.basesyntax;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private String operation;
    private String fruitItem;
    private Integer quantity;
    private LocalDate date;

    public Transaction(String operation, String fruitItem, String quantity, String date) {
        this.operation = operation;
        this.fruitItem = fruitItem;
        this.quantity = Integer.parseInt(quantity);
        this.date = LocalDate.parse(date);
    }

    public Transaction() {
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setFruitItem(String fruitItem) {
        this.fruitItem = fruitItem;
    }

    public void setQuantity(String quantity) {
        this.quantity = Integer.parseInt(quantity);
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }

    public String getOperation() {
        return operation;
    }

    public String getFruitItem() {
        return fruitItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LocalDate getDate() {
        return date;
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
        return operation.equals(that.operation)
                && fruitItem.equals(that.fruitItem)
                && quantity.equals(that.quantity)
                && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruitItem, quantity, date);
    }

}
