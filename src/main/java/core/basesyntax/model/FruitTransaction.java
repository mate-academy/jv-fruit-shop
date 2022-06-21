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

        private final String abbrOperation;

        Operation(String abbrOperation) {
            this.abbrOperation = abbrOperation;
        }

        public String getAbbrOperation() {
            return abbrOperation;
        }

        public static Operation getOperation(String abbrOperation) {
            for (Operation operation : Operation.values()) {
                if (operation.getAbbrOperation().equals(abbrOperation)) {
                    return operation;
                }
            }
            throw new RuntimeException("Operation does not correct");
        }
    }
}
