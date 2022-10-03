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

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation getOperation(String operation) {
            if (operation.equals(BALANCE.operation)) {
                return BALANCE;
            }
            if (operation.equals(SUPPLY.operation)) {
                return SUPPLY;
            }
            if (operation.equals(PURCHASE.operation)) {
                return PURCHASE;
            }
            if (operation.equals(RETURN.operation)) {
                return RETURN;
            }
            throw new RuntimeException("Invalid input " + operation);
        }
    }
}
