package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r"),
    PURCHASE("p");

    private final String operationShortName;

    Operation(String operationShortName) {
        this.operationShortName = operationShortName;
    }

    public String getShortNameOperation() {
        return operationShortName;
    }

    public static Operation getOperationByShortName(String operationType) {
        for (Operation operation : Operation.values()) {
            if (operation.getShortNameOperation().equals(operationType)) {
                return operation;
            }
        }
        throw new RuntimeException("This operation is wrong: " + operationType);
    }
}
