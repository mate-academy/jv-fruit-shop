package core.basesyntax.model;

import core.basesyntax.exception.NoSuchOperationException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final String NO_SUCH_OPERATION_MESSAGE =
            "This operation is not in the supported list: ";
    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation fromString(String operationInString) {
        switch (operationInString) {
            case "b" -> {
                return BALANCE;
            }
            case "s" -> {
                return SUPPLY;
            }
            case "p" -> {
                return PURCHASE;
            }
            case "r" -> {
                return RETURN;
            }
            default -> throw new NoSuchOperationException(
                    NO_SUCH_OPERATION_MESSAGE + operationInString);
        }
    }
}
