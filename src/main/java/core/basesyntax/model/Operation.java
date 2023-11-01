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

    public String getCode() {
        return code;
    }

    public static Operation getOperationValue(String code) {

        return switch (code) {
            case "b" -> Operation.valueOf("BALANCE");
            case "r" -> Operation.valueOf("RETURN");
            case "p" -> Operation.valueOf("PURCHASE");
            case "s" -> Operation.valueOf("SUPPLY");
            default -> throw new RuntimeException("No such code in enum values");
        };
    }
}
