package core.basesyntax.model;

public class FruitTransaction {
    private Operation[] operations = Operation.values();
    private Operation operation;
    private String fruit;
    private int quantity;

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

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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

        public String getOperation() {
            return operation;
        }
    }

    public FruitTransaction.Operation getOperationByLetter(String activity) {
        for (Operation operation : operations) {
            if (operation.getOperation().equals(activity)) {
                return operation;
            }
        }
        throw new RuntimeException("No such activity " + activity);
    }
}
