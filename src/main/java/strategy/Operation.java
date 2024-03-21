package strategy;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation fromString(String operation) {
        for (Operation value : Operation.values()) {
            if (operation.equals(value.getCode())) {
                return value;
            }
        }
        throw new IllegalArgumentException("Can not get operation from type " + operation + "!");
    }

    public String getCode() {
        return code;
    }
}
