package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

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

    public Operation getOperation() {
        return operation;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String abbr;

        Operation(String operation) {
            this.abbr = operation;
        }

        public String getOperation() {
            return abbr;
        }

        public static Operation getOperation(String operation) {
            for (Operation operation1 : Operation.values()) {
                if (operation1.getOperation().equals(operation)) {
                    return operation1;
                }
            }
            throw new RuntimeException("Invalid operation");
        }
    }
}
