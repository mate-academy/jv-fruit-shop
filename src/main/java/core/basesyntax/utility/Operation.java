package core.basesyntax.utility;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operationName;

    Operation(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }

    public static Operation getByValue(String operationFirstLetter) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getOperationName().equals(operationFirstLetter))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
