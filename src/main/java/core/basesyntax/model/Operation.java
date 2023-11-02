package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final String ILLEGAL_VALUE_MESSAGE = "No such value: ";
    private String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation getOperationByCode(String code) {
        return switch (code) {
            case "b" -> BALANCE;
            case "s" -> SUPPLY;
            case "p" -> PURCHASE;
            case "r" -> RETURN;
            default -> throw new IllegalArgumentException(ILLEGAL_VALUE_MESSAGE + code);
        };
    }
}
