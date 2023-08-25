package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getByCode(String code) {
        for (Operation o: Operation.values()) {
            if (o.code.equals(code)) {
                return o;
            }
        }
        throw new RuntimeException("Operation d'n contain code of " + code);
    }
}
