package service;

public enum OperationType {
    BALANCE("b"),
    PURCHASE("p"),
    SUPPLY("s"),
    RETURN("r");

    private final String value;

    OperationType(String type) {
        this.value = type;
    }

    public String getValue() {
        return value;
    }

    public static OperationType findOperationType(String operationType) {
        switch (operationType) {
            case "b":
                return BALANCE;
            case "p":
                return PURCHASE;
            case "r":
                return RETURN;
            default:
                return SUPPLY;
        }
    }
}
