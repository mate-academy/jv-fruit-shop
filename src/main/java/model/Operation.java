package model;

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
        for (Operation operation : values()) {
            if (operation.getOperation().equals(code)) {
                return operation;
            }
        }
        throw new RuntimeException("Incorrect code " + code);
    }
}
