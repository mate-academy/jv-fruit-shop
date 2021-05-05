package core.basesyntax.model;

import java.util.Arrays;

public enum OperationType {
    BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

    private String operationType;

    OperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperation() {
        return operationType;
    }

    public static OperationType getOperationTypeByLetter(String letter) {
        return Arrays.stream(OperationType.values())
                .filter(type -> type.getOperation().contains(letter))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid operation type"));
    }
}
