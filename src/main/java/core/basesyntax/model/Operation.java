package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String shortName;

    Operation(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static Operation get(String data) {
        for (Operation operation: values()) {
            if (operation.getShortName().equals(data)) {
                return operation;
            }
        }
        throw new RuntimeException("Operation is invalid!");
    }
}
