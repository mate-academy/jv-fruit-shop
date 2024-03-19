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

    public static Operation fromCode(String type) {
        for (Operation value : Operation.values()) {
            if (type.equals(value.getCode())) {
                return value;
            }
        }
        throw new RuntimeException("Can not get operation from type " + type + "!");
    }
}
