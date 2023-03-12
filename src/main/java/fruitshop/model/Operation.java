package fruitshop.model;

public enum Operation {
    BALANCE('b'),
    SUPPLY('s'),
    PURCHASE('p'),
    RETURN('r');

    private final char operation;

    Operation(char operation) {
        this.operation = operation;
    }

    public char getOperation() {
        return operation;
    }

    public static Operation getByValue(char operation) {
        for (Operation v : values()) {
            if (v.operation == operation) {
                return v;
            }
        }
        throw new RuntimeException("Operation does not exist: " + operation);
    }
}
