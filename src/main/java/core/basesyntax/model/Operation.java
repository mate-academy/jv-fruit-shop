package core.basesyntax.model;

public enum Operation {
    BALANCE,
    RETURN,
    SUPPLY,
    PURCHASE;

    public static boolean isPresent(String value) {
        Operation [] operations = values();
        for (Operation operation: operations) {
            if (operation.toString().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
