package core.basesyntax.database;

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

    public static Operation getByCode(Object obj) {
        if (obj.equals(Operation.BALANCE.code)) {
            return Operation.BALANCE;
        }
        if (obj.equals(Operation.SUPPLY.code)) {
            return Operation.SUPPLY;
        }
        if (obj.equals(Operation.PURCHASE.code)) {
            return Operation.PURCHASE;
        }
        if (obj.equals(Operation.RETURN.code)) {
            return Operation.RETURN;
        }
        throw new RuntimeException("Incorrect operation type " + obj);
    }
}

