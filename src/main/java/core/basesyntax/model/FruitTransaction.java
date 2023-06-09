package core.basesyntax.model;

import java.util.regex.Pattern;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public FruitTransaction setOperation(Operation operation) {
        this.operation = operation;
        return this;
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

    public static Pattern greatOperationPattern() {
        StringBuilder patternBuilder = new StringBuilder();
        for (Operation operation : Operation.values()) {
            patternBuilder.append(operation.getCode());
        }
        return Pattern.compile("[" + patternBuilder.toString() + "]");
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getOperationByCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new NullPointerException("Incorrect code for operations " + code);
        }
    }
}
