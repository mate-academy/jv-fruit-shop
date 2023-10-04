package core.shop.model;

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

    public static OperationType fromValue(String value) {
        for (OperationType operationType : OperationType.values()) {
            if (operationType.code.equals(value)) {
                return operationType;
            }
        }
        throw new IllegalArgumentException("Invalid operation type value: " + value);
    }
}
