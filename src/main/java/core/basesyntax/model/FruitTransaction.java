package core.basesyntax.model;

public class FruitTransaction {
    private String fruitType;
    private Operation operation;
    private int quantity;

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String type) {
        this.fruitType = type;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public static Operation getOperationBySymbol(String operation) {
            for (Operation e: values()) {
                if (e.operation.equals(operation)) {
                    return e;
                }
            }
            throw new RuntimeException("There is no such operation: " + operation);
        }
    }
}
