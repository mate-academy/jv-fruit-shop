package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation fromCode(String code) {
        Operation operation = null;
        if (code.equals(BALANCE.getCode())) {
            operation = BALANCE;
        }
        if (code.equals(SUPPLY.getCode())) {
            operation = SUPPLY;
        }
        if (code.equals(PURCHASE.getCode())) {
            operation = PURCHASE;
        }
        if (code.equals(RETURN.getCode())) {
            operation = RETURN;
        }
        return operation;
    }

    public String getCode() {
        return code;
    }
}
