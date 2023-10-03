package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;

    private Fruit fruit;

    private int quantity;

    public FruitTransaction(Operation operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
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

        private String operationType;

        Operation(String operationType) {
            this.operationType = operationType;
        }

        public String getOperationType() {
            return operationType;
        }
    }
}
