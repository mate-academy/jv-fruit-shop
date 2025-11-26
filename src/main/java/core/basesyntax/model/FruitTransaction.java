package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String name;
    private Integer quantity;

    public FruitTransaction() {
    }

    public FruitTransaction(Operation operation, String name, Integer quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation=" + operation
                + ", name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
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

        public static Operation getCode(String operation) {
            return Arrays.stream(values())
                    .filter(o -> o.code.equals(operation))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Unexpected value: " + operation));
        }
    }
}
