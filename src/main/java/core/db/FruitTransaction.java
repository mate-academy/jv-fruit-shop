package core.db;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;
    private int sign;

    private FruitTransaction(Operation operation, String fruit, int quantity, int sign) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
        this.sign = sign;
    }

    public static FruitTransaction build(String stringOperation, String stringFruit, int quantity) {
        Operation operation = getOperationFromString(stringOperation);
        int sign;
        if (operation == Operation.BALANCE || operation == Operation.SUPPLY) {
            sign = 1;
        } else if (operation == Operation.PURCHASE || operation == Operation.RETURN) {
            sign = -1;
        } else {
            throw new RuntimeException("The operation is not supported");
        }
        return new FruitTransaction(operation, stringFruit, quantity, sign);
    }

    public static Operation getOperationFromString(String stringOperation) {
        return Arrays.stream(Operation.values())
                .filter(x -> x.getOperation().equals(stringOperation))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Operation " + stringOperation + " does not exist"));
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

    public int getSign() {
        return sign;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }
}
