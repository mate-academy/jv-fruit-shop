package core.basesyntax.model;

public class FruitTransaction {
    private OperationType operation;
    private String fruitName;
    private int quantity;

    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum OperationType {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operationType;

        OperationType(String operationType) {
            this.operationType = operationType;
        }

        public String getOperationType() {
            return operationType;
        }
    }
}
