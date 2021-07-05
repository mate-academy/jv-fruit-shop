package core.basesyntax.model;

public enum Operation {
    BALANCE("b"), SUPPLY("s"),
    PURCHASE("p"), RETURN("r");

    private String shortName;

    Operation(String shortOperationType) {
        this.shortName = shortOperationType;
    }

    public String getShortNameOperation() {
        return shortName;
    }

    public static Operation getOperationByShortName(String operationType) {
        for (Operation operation : Operation.values()) {
            if (operation.getShortNameOperation().equals(operationType)) {
                return operation;
            }
        }
        throw new RuntimeException("There is no such type of operation:"
                + "<" + operationType + ">");
    }
}
