package core.basesyntax.dto;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    OperationType(String symbol) {
    }

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
