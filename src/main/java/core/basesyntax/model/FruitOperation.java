package core.basesyntax.model;

import java.util.Arrays;

public class FruitOperation {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitOperation() {
    }

    public FruitOperation(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

        public static Operation getOperation(String code) {
            return Arrays.stream(Operation.values())
                    .filter(operation -> operation.code.equals(code))
                    .findFirst()
                    .orElseThrow(() ->
                            new IllegalArgumentException("Invalid operation code: " + code));

        }

        public String getCode() {
            return code;
        }
    }
}
