package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String firstLetter;

    Operation(String operation) {
        this.firstLetter = operation;
    }

    public static Operation getOperationByFirstLetter(String firstLetter) {
        for (Operation operation: Operation.values()) {
            if (firstLetter.trim().equals(operation.firstLetter)) {
                return operation;
            }
        }
        throw new RuntimeException("Can't find operation by first letter "
                + firstLetter);
    }
}
