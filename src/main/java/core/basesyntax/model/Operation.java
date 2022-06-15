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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public static Operation getOperationFromString(String operation) {
        if (operation.equals("b")) {
            return BALANCE;
        }
        if (operation.equals("s")) {
            return SUPPLY;
        }
        if (operation.equals("p")) {
            return PURCHASE;
        }
        if (operation.equals("r")) {
            return RETURN;
        }
        return null;
    }
}
