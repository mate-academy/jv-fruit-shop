package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");

    private String value;

    Operation(String value) {
        this.value = value;
    }

    public static Operation getKey(String someOperation) {
        for (Operation operation : Operation.values()) {
            if (operation.value.equals(someOperation)) {
                return operation;
            }
        }
        throw new RuntimeException("Cannot find operation");
    }

    public static boolean contains(String someOperation) {
        getKey(someOperation);
        return true;
    }
}
