package core.basesyntax.tranasctions;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    // getters, setters, ...
    @Override
    public String toString() {
        return "FruitTransaction{" +
                "operation=" + operation +
                ", fruit='" + fruit + '\'' +
                ", quantity=" + quantity +
                '}';
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

        public String getCode() {
            return code;
        }

        public static Operation coverToOperation(String code) {
            return Arrays.stream(Operation.values())
                    .filter(e -> e.getCode().equals(code))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException(("Operation with code [%s] "
                            + "does not exist!").formatted(code)));
        }
    }
}
