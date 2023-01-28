package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation getByCode(String code) {
        for (Operation element : values()) {
            if (element.getOperation().equals(code)) {
                return element;
            }
        }
        throw new RuntimeException("Invalid code " + code);
    }
}
