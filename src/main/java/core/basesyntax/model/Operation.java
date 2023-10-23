package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");
    private String code;

    Operation(String code) {
        this.code = code;
    }
    public static Operation getOperationFromString(String string) {
            return switch (string) {
                case "r" -> Operation.RETURN;
                case "s" -> Operation.SUPPLY;
                case "b" -> Operation.BALANCE;
                default -> Operation.PURCHASE;
            };
    }
}
