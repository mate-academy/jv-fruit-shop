package core.basesyntax.service.strategy;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation of(String letter) {
        for (Operation action : Operation.values()) {
            if (action.getCode().equalsIgnoreCase(letter)) {
                return action;
            }
        }
        throw new IllegalArgumentException("No operation with letter " + letter + " in enum");
    }

    public String getCode() {
        return code;
    }
}
