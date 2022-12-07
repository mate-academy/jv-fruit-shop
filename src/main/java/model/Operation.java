package model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation getByCode(String code) {
        switch (code) {
            case "b" :
                return Operation.BALANCE;
            case "s" :
                return Operation.SUPPLY;
            case "p" :
                return Operation.PURCHASE;
            case "r" :
                return Operation.RETURN;
            default:
                throw new RuntimeException("Can't find operation " + code);
        }
    }
}

