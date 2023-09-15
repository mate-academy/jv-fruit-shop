package core.basesyntax.model;

import java.util.Objects;

public final class FruitTransaction {
    private final String fruitName;
    private final Operation operation;
    private final int quantity;

    public FruitTransaction(String fruitName, Operation operation, int quantity) {
        this.fruitName = fruitName;
        this.operation = operation;
        this.quantity = quantity;
    }

    public String fruitName() {
        return fruitName;
    }

    public Operation operation() {
        return operation;
    }

    public int quantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        FruitTransaction that = (FruitTransaction) obj;
        return Objects.equals(this.fruitName, that.fruitName)
                && Objects.equals(this.operation, that.operation)
                && this.quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName, operation, quantity);
    }

    @Override
    public String toString() {
        return "FruitTransaction["
                + "fruitName=" + fruitName + ", "
                + "operation=" + operation + ", "
                + "quantity=" + quantity + ']';
    }
}
