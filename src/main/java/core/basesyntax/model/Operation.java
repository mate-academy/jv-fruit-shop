package core.basesyntax.model;

import core.basesyntax.exceptions.WrongOperationException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation getOperation(String operation) {
        switch (operation) {
            case "b" :
                return BALANCE;
            case "s" :
                return SUPPLY;
            case "p" :
                return PURCHASE;
            case "r" :
                return RETURN;
            default :
                throw new WrongOperationException("Wrong operation " + operation);
        }
    }
}
