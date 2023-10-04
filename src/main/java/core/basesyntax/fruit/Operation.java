package core.basesyntax.fruit;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;
    Operation(String code) {
        this.code = code;
    }

    public static Operation getByCode(String operationCode) {
        for (Operation value : Operation.values()) {
            if (value.getCode().equals(operationCode)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No correct operation code" + operationCode);
    }

    public String getCode() {
        return code;
    }
}
