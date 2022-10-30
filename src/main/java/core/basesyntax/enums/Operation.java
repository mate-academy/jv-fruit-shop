package core.basesyntax.enums;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String value;

    Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Operation getFromEqualString(String value) {
        for (Operation operation : values()) {
            if (operation.value.equals(value)) {
                return operation;
            }
        }
        return null;
    }
}
