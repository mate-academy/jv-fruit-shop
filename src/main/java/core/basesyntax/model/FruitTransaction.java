package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public static Operation getEnumByValue(String operationType) {
            for (Operation operation : Operation.values()) {
                if (operation.getOperation().equals(operationType)) {
                    return operation;
                }
            }
            throw new RuntimeException("Unknown operation: " + operationType);
        }

        public String getOperation() {
            return operation;
        }
    }

    public FruitTransaction(
            Operation operation,
            String fruit,
            int quantity
    ) {
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
}
