package core.basesyntax.operation;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String shortName;

    OperationType(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static OperationType get(String operationType) {
        for (OperationType operation : values()) {
            if (operation.getShortName().equals(operationType)) {
                return operation;
            }
        }
        return null;
    }
}
