package core.basesyntax;

public enum Operation {
    PURCHASE("p"),
    SUPPLY("s"),
    BALANCE("b"),
    RETURN("r");
    private final String typeOperation;

    Operation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public static Operation checkTypeOperation(String typeOperation) {
        for (Operation value : Operation.values()) {
            if (value.typeOperation.equals(typeOperation)) {
                return value;
            }
        }
        throw new RuntimeException("the type of operation is not correct");
    }
}
