package core.basesyntax.operations;

public enum Operations {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operation;

    Operations(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static boolean contains(String operation) {
        for (Operations value : Operations.values()) {
            if (operation.equals(value.getOperation())) {
                return true;
            }
        }
        return false;
    }
}
