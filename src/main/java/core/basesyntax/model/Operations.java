package core.basesyntax.model;

public enum Operations {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Operations(String code) {
        this.code = code;
    }

    public static Operations getOperationByCode(String code) {
        for (Operations operation : Operations.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

    public String getCode() {
        return code;
    }
}
