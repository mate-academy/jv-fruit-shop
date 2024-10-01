package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class Transaction {
    private final Operation operation;
    private final Fruit fruit;
    private final int quantity;

    public Transaction(Operation operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        PURCHASE("p"),
        RETURN("r"),
        SUPPLY("s");


        private static final Map<String, Operation> operationMap = new HashMap<>();
        private final String code;
        static {
            for (Operation operation : Operation.values()) {
                operationMap.put(operation.code, operation);
            }
        }

        Operation(String code) {
            this.code = code;
        }

        public static Operation fromCode(String code) {
            Operation operation = operationMap.get(code.toLowerCase());
            if (operation == null) {
                throw new IllegalArgumentException("Unknown operation code: " + code);
            }
            return operation;
        }
    }
}
