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

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
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

        public static Operation getOperation(String code) {
            switch (code) {
                case "b":
                    return Operation.BALANCE;
                case "s":
                    return Operation.SUPPLY;
                case "p":
                    return Operation.PURCHASE;
                case "r":
                    return Operation.RETURN;
                default:
                    throw new RuntimeException("Unknown operation type");
            }
        }

    }
}
