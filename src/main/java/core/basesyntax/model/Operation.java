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

    public static Operation getOperationFromCode(String operationValue) {
        return switch (operationValue) {
            case "b" -> BALANCE;
            case "s" -> SUPPLY;
            case "p" -> PURCHASE;
            case "r" -> RETURN;
            default -> throw new RuntimeException("You have entered a non-existent transaction."
                    + operationValue
                    + "Available values: BALANCE, SUPPLY, PURCHASE, RETURN");
        };
    }
}
