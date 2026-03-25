package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private String fruit;
    private int quantity;
    private Operation operation;

    public FruitTransaction(String operationCode, String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
        operation = Operation.fromCode(operationCode);
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");
        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation fromCode(String dataCode) {
            return Arrays.stream(values())
                    .filter(operation1 -> operation1.code.equals(dataCode))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown code: " + dataCode));
        }
    }
}
