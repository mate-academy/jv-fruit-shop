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

    public static FruitOperation getOperationFromCode(String operationCode) {
        for (FruitOperation fruitOperation : values()) {
            if (fruitOperation.getCode().equals(operationCode)) {
                return fruitOperation;
            }
        }
        throw new RuntimeException("Unknown operation code: " + operationCode);
    }
}
