package core.basesyntax.model;

import java.util.NoSuchElementException;

public enum Operation {
    BALANCE,
    SUPPLY,
    PURCHASE,
    RETURN;

    public static Operation getOperation(String operation) {
        switch (operation) {
            case "b":
                return Operation.BALANCE;
            case "s":
                return Operation.SUPPLY;
            case "p":
                return Operation.PURCHASE;
            case "r":
                return Operation.RETURN;
            default:
                throw new NoSuchElementException("Unknown operation " + operation);
        }
    }
}
