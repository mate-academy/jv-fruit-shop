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
        return this.code;
    }

    public static Operation getType(String type) throws IllegalArgumentException {
        for (Operation operation: Operation.values()) {
            if (operation.code.equalsIgnoreCase(type)) {
                return operation;
            }
        }

        throw new IllegalArgumentException("No such code transaction - " + type);
    }
}
