package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String type;

    Operation(String type) {
        this.type = type;
    }

    public static Operation getOperation(String value) {
        for (Operation operation : values()) {
            if (operation.type.equals(value)) {
                return operation;
            }
        }
        throw new RuntimeException("File haven't type of activity " + value);
    }
}
