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

    public static Operation getOperation(String operation) {
        if (operation.equals("b")) {
            return Operation.BALANCE;
        }
        if (operation.equals("s")) {
            return Operation.SUPPLY;
        }
        if (operation.equals("r")) {
            return Operation.RETURN;
        }
        if (operation.equals("p")) {
            return Operation.PURCHASE;
        }
        throw new RuntimeException("Invalid operation");
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
}
