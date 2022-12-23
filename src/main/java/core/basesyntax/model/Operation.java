package core.basesyntax.model;

public enum Operation {
    BALANCE,
    SUPPLY,
    PURCHASE,
    RETURN;

    public static Operation getByCode(String operation) {
        Operation useOperation = null;
        if (BALANCE.toString().startsWith(operation)) {
            useOperation = BALANCE;
        } else if (SUPPLY.toString().startsWith(operation)) {
            useOperation = SUPPLY;
        } else if (PURCHASE.toString().startsWith(operation)) {
            useOperation = PURCHASE;
        } else if (RETURN.toString().startsWith(operation)) {
            useOperation = RETURN;
        }
        return useOperation;
    }
}
