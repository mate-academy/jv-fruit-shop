package core.basesyntax.model;

import java.util.NoSuchElementException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation getByCode(String operation) {
        switch (operation) {
            case "b": return Operation.BALANCE;
            case "s": return Operation.SUPPLY;
            case "p": return Operation.PURCHASE;
            case "r": return Operation.RETURN;
            default: throw new NoSuchElementException("Operation " + operation + " doesn't exist");
        }
    }
}
