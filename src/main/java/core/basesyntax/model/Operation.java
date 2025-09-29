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

    public String getCode() {
        return code;
    }

    public static Operation fromCode(String code) {
        for (Operation op : Operation.values()) {
            if (op.getCode().equals(code)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operation code: " + code);
    }
}
