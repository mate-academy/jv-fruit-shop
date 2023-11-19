package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private static final String INVALID_CODE_MESSAGE = "Invalid operation code: ";
    private final String code;
    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getOperationByCode(String code) {
        Operation[] values = Operation.values();
        for (Operation operation : values) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException(INVALID_CODE_MESSAGE + code);
    }
}

