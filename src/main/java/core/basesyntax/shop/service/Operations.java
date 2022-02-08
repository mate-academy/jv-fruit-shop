package core.basesyntax.shop.service;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Operations {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN_BACK("r");

    private String operationCode;

    Operations(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public static String operationsString() {
        return Arrays.stream(Operations.values())
                .map(Operations::getOperationCode)
                .collect(Collectors.joining());
    }
}
