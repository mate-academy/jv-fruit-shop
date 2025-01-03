package core.basesyntax;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation getOperation(String code) {
        for (Operation value : Operation.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(code + " operation doesn't exist.");
    }

    public String getCode() {
        return code;
    }
}