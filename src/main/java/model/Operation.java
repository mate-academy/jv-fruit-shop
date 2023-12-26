package model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Operation(String code) {
        this.code = code;
    }

    public String getOperation() {
        return code;
    }

    public Operation getOperationType() {
        return this;
    }

    public static Operation fromCode(String str) {
        for (Operation value : values()) {
            if (value.code.equalsIgnoreCase(str)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + str);
    }

}
