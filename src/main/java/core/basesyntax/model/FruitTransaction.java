package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        if (operation == null) {
            throw new RuntimeException("Operation can't be null");
        }
        if (fruit == null || fruit.isBlank()) {
            throw new RuntimeException("Fruit name can't be null or empty");
        }
        if (quantity < 0) {
            throw new RuntimeException("Quantity can't be negative " + quantity);
        }
        this.operation = operation;
        this.fruit = fruit.trim();
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation=" + operation
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) o;
        return quantity == that.quantity
                && operation == that.operation
                && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, quantity);
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation fromCode(String code) {
            if (code == null || code.isBlank()) {
                throw new RuntimeException("Operation code can't be null or empty");
            }
            String trimCode = code.trim();
            for (Operation operation : values()) {
                if (operation.code.equals(trimCode)) {
                    return operation;
                }
            }
            throw new RuntimeException("Not available operation code " + trimCode);
        }

        public String getCode() {
            return code;
        }
    }
}
