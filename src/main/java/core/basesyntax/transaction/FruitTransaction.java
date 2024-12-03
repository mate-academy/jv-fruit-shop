package core.basesyntax.transaction;

import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruitName;
    private int quantity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) o;
        return quantity == that.quantity && operation == that.operation
                && Objects.equals(fruitName, that.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruitName, quantity);
    }

    public enum Operation {
        /**
         * B Represents a balance operation where the initial
         * stock of fruits is set.
         */
        B,
        /**
         * P Represents a purchase operation where fruits
         * are purchased by a customer.
         */
        P,
        /**
         * S Represents a supply operation where fruits are
         * supplied to increase the stock.
         */
        S,
        /**
         * R Represents a return operation where fruits are
         * returned by the customer.
         */
        R
    }
}
