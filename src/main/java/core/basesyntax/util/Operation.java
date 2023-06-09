package core.basesyntax.util;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static String getCode(String operationCode) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equalsIgnoreCase(operationCode)) {
                return operation.getCode();
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + operationCode);
    }

    public void setCode(String code) {
        this.code = code;
    }
}
