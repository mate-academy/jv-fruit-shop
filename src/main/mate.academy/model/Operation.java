package model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation get(String operationType) {
        for (Operation operation : values()) {
            if (operation.getOperation().equals(operationType)) {
                return operation;
            }
        }
        return null;
    }
}
