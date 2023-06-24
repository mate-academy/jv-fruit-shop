package core.basesyntax.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
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

        private static final Map<String, Operation> OPERATION_MAP = new HashMap<>();

        static {
            Arrays.stream(values())
                    .forEach(operation -> OPERATION_MAP.put(operation.getFirstLetter(), operation));
        }

        private final String firstLetter;

        Operation(String firstLetter) {
            this.firstLetter = firstLetter;
        }

        public static Operation get(String firstLetter) {
            return OPERATION_MAP.get(firstLetter);
        }

        public String getFirstLetter() {
            return firstLetter;
        }
    }
}
