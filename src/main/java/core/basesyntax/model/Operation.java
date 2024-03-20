package core.basesyntax.model;

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

    public static Operation fromCode(String code) {
        for (Operation operationType : Operation.values()) {
            if (operationType.getCode().equals(code)) {
                return operationType;
            }
        }
        throw new IllegalArgumentException("Invalid Operation code: " + code);
    }
}
