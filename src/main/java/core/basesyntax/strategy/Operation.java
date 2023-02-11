package core.basesyntax.strategy;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation getOperationByCode(String code) {
        for (Operation operation : values()) {
            if (operation.code.equals(code)) {
                return operation;
            }
        }
        throw new RuntimeException("Wrong operation code");
    }
}
