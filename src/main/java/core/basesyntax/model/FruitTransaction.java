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

        private String action;

        Operation(String action) {
            this.action = action;
        }

        public static Operation getOperation(String operations) {
            for (Operation operation : Operation.values()) {
                if (operation.action.equals(operations)) {
                    return operation;
                }
            }
            throw new RuntimeException("Can't find an operation by operations list " + operations);
        }
    }
}
