package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        if (operation == null || fruit == null) {
            throw new IllegalArgumentException("Operation or fruit can't be null");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("quantity can't be negative");
        }

        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public void setFruit(String fruit) {
        if (fruit == null) {
            throw new IllegalArgumentException("fruit can't be null");
        }

        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity can't be negative");
        }

        this.quantity = quantity;
    }

    public void setOperation(Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("operation can't be null");
        }

        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
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

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation valueOfCode(String code) {
            for (Operation op : Operation.values()) {
                if (op.code.equals(code)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Unknown operation code: " + code);
        }
    }
}
