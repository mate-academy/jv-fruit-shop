package core.basesyntax.model;

import java.util.NoSuchElementException;

public enum OperationType {
    BALANCE,
    PURCHASE,
    RETURN,
    SUPPLY;

    public static OperationType getOperation(String operation) {
        switch (operation) {
            case "b":
                return OperationType.BALANCE;
            case "s":
                return OperationType.SUPPLY;
            case "p":
                return OperationType.PURCHASE;
            case "r":
                return OperationType.RETURN;
            default:
                throw new NoSuchElementException("Entered operation is invalid - " + operation);
        }
    }
}
