package model;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return this.operation;
    }

    public String getFruit() {
        return this.fruit;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", operation.getCode(), fruit, quantity);
    }
}
