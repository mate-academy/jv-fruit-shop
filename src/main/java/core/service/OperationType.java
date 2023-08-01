package core.service;

public enum OperationType {
    B("b"),
    S("s"),
    R("r"),
    P("p");

    private final String code;

    OperationType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
