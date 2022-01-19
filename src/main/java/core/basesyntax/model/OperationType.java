package core.basesyntax.model;

import core.basesyntax.exceptions.IncorectOperationException;

public enum OperationType {
    BALANCE, RETURN, SUPPLY, PURCHASE;

    public static OperationType getType(String type) {
        switch (type) {
            case "b" :
                return OperationType.BALANCE;
            case "r" :
                return OperationType.RETURN;
            case "s" :
                return OperationType.SUPPLY;
            case "p" :
                return OperationType.PURCHASE;
            default:
                throw new IncorectOperationException("Wrong operation " + type);
        }
    }
}
