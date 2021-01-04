package core.basesyntax.model;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operationSymbol;

    Operation(String operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public String getOperationSymbol() {
        return operationSymbol;
    }

    public static Operation findValue(String operationSymbol) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getOperationSymbol().equals(operationSymbol))
                .findFirst()
                .get();
    }
}
