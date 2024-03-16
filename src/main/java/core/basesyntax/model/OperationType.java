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

    public static String getAllCodes() {
        StringBuilder codes = new StringBuilder();
        for (var operationType : OperationType.values()) {
            codes.append(operationType.getCode());
        }
        return codes.toString();
    }
}
