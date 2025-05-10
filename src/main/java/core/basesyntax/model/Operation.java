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

    public static Operation fromCode(String code) {
        for (Operation o : Operation.values()) {
            if (o.getCode().equals(code)) {
                return o;
            }
        }
        throw new IllegalArgumentException("Unknown operation code: " + code);
    }

    public String getCode() {
        return code;
    }
}
