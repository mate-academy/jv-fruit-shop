package model;

import exceptions.NoSuchOperationException;

import java.util.NoSuchElementException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final String NO_SUCH_OPERATION_MESSAGE = "This operation is not in the supported list: ";
    private final String code;

    Operation(String code) {
      this.code = code;
    }
    public String getCode() {
        return code;
    }

    public static Operation fromString(String operationInString) {
        for (Operation operation : Operation.values()) {
            if (operation.code.equalsIgnoreCase(operationInString)) {
                return operation;
            }
        }
        throw new NoSuchOperationException(NO_SUCH_OPERATION_MESSAGE + operationInString);
    }
}
