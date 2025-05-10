package core.basesyntax.model;

public enum Operations {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operations(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operations getOperations(String code) {
        for (Operations operation : Operations.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("The operation for the given code is invalid: " + code);
    }
}
