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

    public static Operation parseOperation(String code, int lineIndex) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equalsIgnoreCase(code)) {
                return operation;
            }
        }
        throw new RuntimeException("Invalid operation symbol in line " + (lineIndex + 1));
    }
}
