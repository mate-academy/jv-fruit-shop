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

    public String getCode() {
        return code;
    }

    public static Operation getByCode(String code) {
        for (Operation o : Operation.values()) {
            if (o.getCode().equals(code)) {
                return o;
            }
        }
        throw new RuntimeException("Unable to perform the operation: " + code);
    }
}
