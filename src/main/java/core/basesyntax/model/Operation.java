package core.basesyntax.model;

import java.util.NoSuchElementException;

public enum Operation {
    BALANCE(),
    PURCHASE(),
    RETURN(),
    SUPPLY();

    public static Operation getOperationByString(String code) {
        return switch (code) {
            case "r" -> Operation.RETURN;
            case "s" -> Operation.SUPPLY;
            case "b" -> Operation.BALANCE;
            case "p" -> Operation.PURCHASE;
            default -> throw new NoSuchElementException("Cannot find operation" + code);
        };
    }
}
