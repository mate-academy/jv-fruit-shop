package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String operationCode, String fruit, int quantity) {
        this.operation = Operation.of(operationCode);
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

        private final String code;

        public static Operation of(String code) {
            return Arrays.stream(Operation.values())
                    .filter(o -> o.getCode().equals(code))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Transaction operation " + code + " not supported"));
        }

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}