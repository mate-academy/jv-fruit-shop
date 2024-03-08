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

    public static Operation fromCode(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.code.equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("No operation with code: " + code);
    }

}
