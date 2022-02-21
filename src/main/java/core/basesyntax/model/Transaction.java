package core.basesyntax.model;

public class Transaction {
    private Operation operationType;
    private Fruit fruit;
    private int amount;

    public Operation getOperationType() {
        return operationType;
    }

    public void setOperationType(Operation operationType) {
        this.operationType = operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");
        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation fromOperation(String operation) {
            for (Operation o : Operation.values()) {
                if (o.operation.equals(operation)) {
                    return o;
                }
            }
            return null;
        }
    }
}
