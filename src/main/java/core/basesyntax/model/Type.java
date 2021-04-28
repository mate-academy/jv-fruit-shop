package core.basesyntax.model;

import core.basesyntax.exceptions.IncorectOperationException;

public enum Type {
    BALANCE, RETURN, SUPPLY, PURCHASE;

    public static Type getType(String type) {
        switch (type) {
            case "b" :
                return Type.BALANCE;
            case "r" :
                return Type.RETURN;
            case "s" :
                return Type.SUPPLY;
            case "p" :
                return Type.PURCHASE;
            default:
                throw new IncorectOperationException("Wrong operation " + type);
        }
    }
}
