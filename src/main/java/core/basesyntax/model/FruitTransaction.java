package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public enum Operation {
        BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation getOperationByCode(String code) {
            for (Operation o : Operation.values()) {
                if (o.operation.equalsIgnoreCase(code)) {
                    return o;
                }
            }
            throw new RuntimeException("Wrong operation code.");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit, operation, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction transaction = (FruitTransaction) o;
        return Objects.equals(fruit, transaction.fruit) && operation == transaction.operation
                && quantity == transaction.quantity;
    }
}
