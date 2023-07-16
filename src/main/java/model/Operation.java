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

    public static Operation getByValue(String typeOperation) {
        for (Operation operation : values()) {
            if (operation.getOperation().equals(typeOperation)) {
                return operation;
            }
        }
        throw new RuntimeException("Can't find type of operation "
                + typeOperation);
    }
}
