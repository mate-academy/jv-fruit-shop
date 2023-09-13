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

    @Override
    public String toString() {
        return "Operation " + operation
                + "; Fruit is " + fruit
                + "; Quantity = " + quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operationType;

        Operation(String operationType) {
            this.operationType = operationType;
        }

        private String getOperationType() {
            return operationType;
        }

        public static Operation getOperationType(String type) {
            for (int i = 0; i < FruitTransaction.Operation.values().length; i++) {
                if (FruitTransaction.Operation.values()[i].getOperationType().equals(type)) {
                    return FruitTransaction.Operation.values()[i];
                }
            }
            throw new RuntimeException("This operation does not exist");
        }
    }
}
