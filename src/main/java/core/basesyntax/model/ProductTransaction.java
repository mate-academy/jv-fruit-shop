package core.basesyntax.model;

import java.util.StringJoiner;

public class ProductTransaction {
    private final Operation operation;
    private final String product;
    private final int quantity;

    public ProductTransaction(Operation operation, String product, int quantity) {
        this.operation = operation;
        this.product = product;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ProductTransaction.class.getSimpleName() + "[", "]")
                .add("operation='" + operation + "'")
                .add("product='" + product + "'")
                .add("quantity=" + quantity)
                .toString();
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }
}
