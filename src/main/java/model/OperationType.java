package model;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private static final String EXCEPTION_MESSAGE = "Invalid Operation Type";
    private final String codeOperation;

    OperationType(String codeOperation) {
        this.codeOperation = codeOperation;
    }

    public String getCodeOperation() {
        return codeOperation;
    }

    public static OperationType getOperationType(String code) {
        switch (code) {
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
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}
