package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = Operation.getOperationByLetter(operation);
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

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public static Operation getOperationByLetter(String letter) {
            for (Operation current: Operation.values()) {
                if (current.operation.equals(letter)) {
                    return current;
                }
            }
            throw new RuntimeException("Can't find an operation by letter " + letter);
        }
    }
}
