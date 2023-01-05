package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
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

        private String type;

        Operation(String operation) {
            this.type = operation;
        }

        public String getOperation() {
            return type;
        }

        public static Operation getOperationByActivity(String activity) {
            for (Operation operation : Operation.values()) {
                if (operation.type.equals(activity)) {
                    return operation;
                }
            }
            throw new RuntimeException("Input file contains wrong data");
        }
    }
}
