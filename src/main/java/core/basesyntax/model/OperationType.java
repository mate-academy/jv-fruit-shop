package core.basesyntax.model;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r"),
    PURCHASE("p");

    private final String operationShortName;

    OperationType(String operationShortName) {
        this.operationShortName = operationShortName;
    }

    public String getShortNameOperation() {
        return operationShortName;
    }

    public static OperationType getOperationByShortName(String operationType) {
        for (OperationType operation : OperationType.values()) {
            if (operation.getShortNameOperation().equals(operationType)) {
                return operation;
            }
        }
        throw new RuntimeException("This operation is wrong: " + operationType);
    }
}
