package core.basesyntax.model;

public class Transaction {

    private Operation operation;
    private String fruit;
    private int quantity;

    public Transaction(String fruit, int quantity) {
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

    public int getQuantity() {
        return quantity;
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

        public static Operation forValue(String data) {
            for (Operation operation : values()) {
                if (operation.getOperation().equals(data)) {
                    return operation;
                }
            }
            throw new RuntimeException("Incorrect code " + data);
        }
    }
}
