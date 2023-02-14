package core.basesyntax.model;

import core.basesyntax.UnknownOperationException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String type;

    Operation(String type) {
        this.type = type;
    }

    public static Operation getOperation(String type) {
        for (Operation operation : Operation.values()) {
            if (operation.type.equals(type)) {
                return operation;
            }
        }
        throw new UnknownOperationException("Entered unknown operation " + type);
    }
}
