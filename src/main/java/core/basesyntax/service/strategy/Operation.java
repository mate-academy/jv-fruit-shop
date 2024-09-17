package core.basesyntax.service.strategy;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation validateOperation(String operationCode) {
        for (Operation value : Operation.values()) {
            if (operationCode.equals(value.getCode())) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + operationCode);
    }

    public String getCode() {
        return code;
    }
}
