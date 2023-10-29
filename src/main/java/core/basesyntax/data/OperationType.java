package core.basesyntax.data;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private final String input;

    OperationType(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public static OperationType getOperation(String input) {
        for (OperationType operation : OperationType.values()) {
            if (operation.getInput().equals(input)) {
                return operation;
            }
        }
        throw new RuntimeException("Incorrect operation type");
    }
}
