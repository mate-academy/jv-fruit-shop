package core.basesyntax.fruitservice;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private String operation;
    private String product;
    private Integer quantity;
    private LocalDate date;

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

    public void setProduct(String product) {
        this.product = product;
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

    public static Transaction build(String operation, String product,
                                    String quantity, String date) {
        Transaction transaction = new Transaction();
        transaction.setOperation(operation);
        transaction.setProduct(product);
        transaction.setQuantity(Integer.parseInt(quantity));
        transaction.setDate(LocalDate.parse(date));
        return transaction;
    }
}
