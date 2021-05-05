package core.basesyntax.service.impl;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"), PURCHASE("p"), RETURN("r");
    private String type;

    OperationType(String type) {
    }

    public static OperationType getOperationType(String type) {
        switch (type) {
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
                throw new RuntimeException("No such operation allowed");
            }
        }
    }
}

