package core.basesyntax.model;

import core.basesyntax.exceptions.IllegalOperationException;

public enum Operation {
    PURCHASE("p"), SUPPLY("s"), RETURN("r"), BALANCE("b");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation getEnum(String operation) {
        switch (operation) {
            case "p" :
                return PURCHASE;
            case "s" :
                return SUPPLY;
            case "r" :
                return RETURN;
            case "b" :
                return BALANCE;
            default :
                throw new IllegalOperationException("Illegal operation " + operation);
        }
    }
}
