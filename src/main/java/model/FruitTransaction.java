package model;

import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String operationCode, String fruit, int quantity)
            throws RuntimeException {
        this.operation = Operation.byCode(operationCode);
        this.fruit = fruit;
        this.quantity = quantity;

        if (this.operation == null) {
            throw new RuntimeException("Undefined operation : " + operationCode);
        } else if (fruit == null || fruit.isEmpty()) {
            throw new RuntimeException("Empty fruit name");
        }
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

        private static final Map<String, Operation> MAP_BY_CODE = new HashMap<>();
        private final String code;

        Operation(String code) {
            this.code = code;
        }

        static {
            for (Operation operation: values()) {
                MAP_BY_CODE.put(operation.code, operation);
            }
        }

        public static Operation byCode(String code) {
            return MAP_BY_CODE.get(code);
        }
    }
}
