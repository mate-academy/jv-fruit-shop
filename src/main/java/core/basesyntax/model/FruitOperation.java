package core.basesyntax.model;

public enum FruitOperation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    FruitOperation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static FruitOperation getFromCode(String code) {
        for (FruitOperation operation : FruitOperation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new RuntimeException("Can't find operation by code " + code);
    }
}
