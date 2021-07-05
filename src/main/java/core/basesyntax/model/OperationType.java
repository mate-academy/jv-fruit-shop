package core.basesyntax.model;

public enum OperationType {
    BALANCE,
    SUPPLY,
    PURCHASE,
    RETURN;

    public static OperationType getOperationType(String symbol) {
        switch (symbol) {
            case "b": {
                return BALANCE;
            }
            case "s": {
                return SUPPLY;
            }
            case "p": {
                return PURCHASE;
            }
            case "r": {
                return RETURN;
            }
            default: {
                throw new IllegalArgumentException("Wrong operation type");
            }
        }
    }
}
