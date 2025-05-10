package model;

public enum OperationsList {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    OperationsList(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static OperationsList fromCode(String code) {
        for (OperationsList op : values()) {
            if (op.getCode().equalsIgnoreCase(code)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operation code: " + code);
    }
}
