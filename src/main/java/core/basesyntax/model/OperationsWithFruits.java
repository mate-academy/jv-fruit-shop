package core.basesyntax.model;

public enum OperationsWithFruits {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;
    OperationsWithFruits(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static OperationsWithFruits getOperation(String code) {
        return switch (code) {
            case "b" -> BALANCE;
            case "s" -> SUPPLY;
            case "p" -> PURCHASE;
            case "r" -> RETURN;
            default -> throw new RuntimeException("Invalid code!" + code);
        };
    }
}
