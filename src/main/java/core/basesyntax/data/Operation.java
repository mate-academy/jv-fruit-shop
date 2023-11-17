package core.basesyntax.data;

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
        return code;
    }

    public static Operation fromString(String code) {
        for (Operation operation : values()) {
            if (operation.code.equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("No operation found with code: " + code);
    }
}
