package core.basesyntax.db.model;

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

        private final String operation;

        Operation(String operationStr) {
            this.operation = operationStr;
        }

        public String getOperationByChar() {
            return operation;
        }

        public static Operation getOperationStrChar(String operationStr) {
            for (Operation element : Operation.values()) {
                if (element.operation.equals(operationStr)) {
                    return element;
                }
            }
            throw new RuntimeException("Can't convert operation");
        }
    }
}
