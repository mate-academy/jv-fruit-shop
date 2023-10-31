package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

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
            default -> null;
        };
    }
}
