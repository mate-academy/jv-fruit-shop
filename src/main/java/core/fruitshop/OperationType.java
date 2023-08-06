package core.fruitshop;

import core.fruitshop.exceptions.IncorrectOperationTypeException;

public enum OperationType {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");
    private static final String INCORRECT_TYPE_EXCEPTION_MESSAGE = "Incorrect operation type. "
            + "Expected: " + BALANCE.getType() + ","
            + SUPPLY.getType() + "," + RETURN.getType() + "or"
            + PURCHASE.getType() + ", but was: ";
    private final String type;

    OperationType(String type) {
        this.type = type;
    }

    public static OperationType fromString(String string) {
        for (OperationType type : OperationType.values()) {
            if (type.getType().equals(string)) {
                return type;
            }
        }
        throw new IncorrectOperationTypeException(INCORRECT_TYPE_EXCEPTION_MESSAGE + string);
    }

    public String getType() {
        return type;
    }
}
