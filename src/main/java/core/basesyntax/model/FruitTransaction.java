package core.basesyntax.model;

public class FruitTransaction {

    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        if (operation == null) {
            throw new RuntimeException("Operation is null");
        }

        if (fruit == null) {
            throw new RuntimeException("Fruit name is null");
        }

        if (fruit.isEmpty()) {
            throw new RuntimeException("Fruit is empty");
        }

        if (quantity < 0) {
            throw new RuntimeException("Quantity can not be lower than zero: " + quantity);
        }

        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
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

        public static Operation fromCode(String code) {
            for (Operation op : Operation.values()) {
                if (op.code.equals(code)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Unknown operation: " + code);
        }

    }

}
