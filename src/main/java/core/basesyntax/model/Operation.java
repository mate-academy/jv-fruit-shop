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

    public static Operation codeOf(String code) {
        for (Operation o: Operation.values()) {
            if (o.code.equals(code)) {
                return o;
            }
        }
        return null;
    }
}
