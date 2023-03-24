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
        switch (code) {
            case "b":
                return BALANCE;
            case "s":
                return SUPPLY;
            case "p":
                return PURCHASE;
            case "r":
                return RETURN;
            default: {
                return null;
            }
        }
    }

    public String getCode() {
        return code;
    }
}
