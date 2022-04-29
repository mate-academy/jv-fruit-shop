package core.basesyntax.model;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r"),
    PURCHASE("p");

    private final String type;

    OperationType(String type) {
        this.type = type;
    }

    public static OperationType getOperationType(String letter) {
        for (OperationType operation : OperationType.values()) {
            if (operation.type.equals(letter)) {
                return operation;
            }
        }
        throw new RuntimeException("Illegal operation type: " + letter);
    }
}
