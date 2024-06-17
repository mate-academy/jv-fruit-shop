package model;

public class FruitRecord {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitRecord(Operation operation, String fruit, int quantity) {
        this.operation = operation;
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

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FruitRecord{"
                + "operation='" + operation + '\''
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
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

        public static Operation valueOfOperation(String operation) {
            for (Operation element : values()) {
                if (element.getOperation().equalsIgnoreCase(operation)) {
                    return element;
                }
            }
            throw new RuntimeException("Invalid code value of operation: " + operation);
        }
    }
}
