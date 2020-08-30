package core.basesyntax.fruitservice;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private String operation;
    private String product;
    private Integer quantity;
    private LocalDate date;

    public Transaction(String operation, String product, String quantity, String date) {
        this.operation = operation;
        this.product = product;
        this.quantity = Integer.parseInt(quantity);
        this.date = LocalDate.parse(date);
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
                && Objects.equals(product, that.product)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, product, quantity, date);
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDate() {
        return date;
    }
}
