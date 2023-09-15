package core.basesyntax.model;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    OperationType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
