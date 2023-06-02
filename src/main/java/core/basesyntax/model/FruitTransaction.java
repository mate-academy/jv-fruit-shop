package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation operation() {
        return operation;
    }

    public String fruit() {
        return fruit;
    }

    public int quantity() {
        return quantity;
    }

    // getters, setters, ...

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation getByCode(String code) {
            return Arrays.stream(Operation.values())
                    .filter(operation -> operation.getCode().equals(code))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Can't find operation by code: "
                            + code));
        }

        public String getCode() {
            return code;
        }
    }
}
