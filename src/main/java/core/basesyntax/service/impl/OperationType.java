package core.basesyntax.service.impl;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private String type;

    OperationType(String type) {
    }

    public String getType() {
        return type;
    }

    public static OperationType getOperationType(String type) {
        switch (type) {
            case "b": {
                return OperationType.BALANCE;
            }
            case "s": {
                return OperationType.SUPPLY;
            }
            case "p": {
                return OperationType.PURCHASE;
            }
            case "r": {
                return OperationType.RETURN;
            }
            default: {
                throw new RuntimeException("No such operation allowed");
            }
        }
    }
}

