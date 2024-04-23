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
        for (Operation op : values()) {
            if (op.getCode().equals(code.trim())) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operation code: " + code);
    }

    public String getCode() {
        return this.code;
    }
}
