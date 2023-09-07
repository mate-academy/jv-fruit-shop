package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String operationCode, String fruit, int quantity) {
        this.operation = setOperation(operationCode);
        this.fruit = fruit;
        this.quantity = quantity;
    }

    private Operation setOperation(String operation) {
        return Arrays.stream(Operation.values())
                .filter(e -> e.code.equalsIgnoreCase(operation.trim()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such operation"));
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

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
