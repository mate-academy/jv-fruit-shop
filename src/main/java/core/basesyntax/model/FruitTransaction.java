package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException("Fruit cannot be null or blank");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
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

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private static final Map<String, Operation> OPERATIONS_BY_CODE = new HashMap<>();

        static {
            for (Operation operation : values()) {
                OPERATIONS_BY_CODE.put(operation.getCode(), operation);
            }
        }

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getByCode(String code) {
            Operation operation = OPERATIONS_BY_CODE.get(code);
            if (operation == null) {
                throw new IllegalArgumentException("Unknown operation code: " + code);
            }
            return operation;
        }
    }
}
