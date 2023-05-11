package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation getByCode(String code) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Code must not be null or empty");
        }
        for (Operation operation : values()) {
            if (operation.code.equalsIgnoreCase(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + code);
    }
}

