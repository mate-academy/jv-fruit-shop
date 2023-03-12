package core.basesyntax.model;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");
    private final String operationCode;

    private Operation(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public static Operation getByCode(String code) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.operationCode.equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unsupported operation code: " + code));
    }
}
