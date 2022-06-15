package core.basesyntax.model;

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

        private final String stringValue;

        Operation(String stringValue) {
            this.stringValue = stringValue;
        }

        public String getOperation() {
            return stringValue;
        }

        public static Operation getOperationFromString(String sign) {
            for (Operation value : Operation.values()) {
                if (value.stringValue.equalsIgnoreCase(sign)) {
                    return value;
                }
            }
            throw new RuntimeException("Wrong operation sign " + sign);
        }
    }
}
