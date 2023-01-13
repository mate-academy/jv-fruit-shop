package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

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

        private String operationKey;

        Operation(String operationKey) {
            this.operationKey = operationKey;
        }

        public static Operation getOperationFromKey(String operationKey) {
            for (Operation operation : Operation.values()) {
                if (operationKey.equals(operation.operationKey)) {
                    return operation;
                }
            }
            throw new RuntimeException("No operations with such operationKey available");
        }
    }
}
