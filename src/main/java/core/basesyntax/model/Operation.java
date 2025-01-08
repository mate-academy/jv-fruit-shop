package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String firstLetterOfOperation;

    Operation(String firstLetterOfOperation) {
        this.firstLetterOfOperation = firstLetterOfOperation;
    }

    public String getFirstLetterOfOperation() {
        return firstLetterOfOperation;
    }

    public static Operation fromCode(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.firstLetterOfOperation.equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + code);
    }
}
