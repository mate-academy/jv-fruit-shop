package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    public static final Map<String, Operation> operations = new HashMap<>();
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    static {
        for (Operation operationType : Operation.values()) {
            operations.put(operationType.getOperation(), operationType);
        }
    }

    private FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
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

    public static class FruitTransactionBuilder {
        private Operation operation;
        private String fruit;
        private int quantity;

        public FruitTransactionBuilder setOperation(Operation operation) {
            this.operation = operation;
            return this;
        }

        public FruitTransactionBuilder setFruit(String fruit) {
            this.fruit = fruit;
            return this;
        }

        public FruitTransactionBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public FruitTransaction build() {
            return new FruitTransaction(operation, fruit, quantity);
        }
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
