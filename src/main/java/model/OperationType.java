package model;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r"),
    NONE("unknown type");

    private String code;

    OperationType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
