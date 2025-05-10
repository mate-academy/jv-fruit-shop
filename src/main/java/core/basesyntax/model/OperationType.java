package core.basesyntax.model;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    OperationType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static OperationType fromCode(String code) {
        for (OperationType operation : OperationType.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("No enum constant for code: " + code);
    }
}
