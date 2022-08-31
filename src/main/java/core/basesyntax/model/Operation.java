package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation getOperation(String operation) {
        switch (operation) {
            case "b" :
                return Operation.BALANCE;
            case "s" :
                return Operation.SUPPLY;
            case "p" :
                return Operation.PURCHASE;
            default:
                return Operation.RETURN;
        }
    }
}
