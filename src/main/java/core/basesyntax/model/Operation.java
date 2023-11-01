package core.basesyntax.model;

import java.util.NoSuchElementException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final String OPERATION_EXCEPTION = "Can't find operation";
    private String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation findByCode(String code) {
        return switch (code) {
            case "b" -> Operation.BALANCE;
            case "s" -> Operation.SUPPLY;
            case "p" -> Operation.PURCHASE;
            case "r" -> Operation.RETURN;
            default -> throw new NoSuchElementException(OPERATION_EXCEPTION);
        };
    }
}
