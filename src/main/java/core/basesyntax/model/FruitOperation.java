package core.basesyntax.model;

public enum FruitOperation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    FruitOperation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static FruitOperation getByOperationCode(String code) {
        for (FruitOperation operation : values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Incorrect operation code: " + code);
    }
}
