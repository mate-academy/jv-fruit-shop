package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;
    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation findByCode(String code) {
        return switch (code) {
            case "b" -> BALANCE;
            case "s" -> SUPPLY;
            case "p" -> PURCHASE;
            case "r" -> RETURN;
            default -> throw new RuntimeException("Code is not exist " + code);
        };
    }
}
