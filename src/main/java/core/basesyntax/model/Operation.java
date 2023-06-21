package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r"),
    NOT_FOUND("n");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation fromValue(String value) {
        for (final Operation operation : values()) {
            if (operation.code.equalsIgnoreCase(value)) {
                return operation;
            }
        }
        return NOT_FOUND;
    }
}
