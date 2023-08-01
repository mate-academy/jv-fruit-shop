package core.basesyntax.model;

import core.basesyntax.exception.InvalidDataFormatException;

import java.util.Optional;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operationSign;

    Operation(String operationSign) {
        this.operationSign = operationSign;
    }

    public String getOperationSign() {
        return operationSign;
    }

    public static Operation of(String operationSign) {
        Optional<Operation> operation = Optional.empty();

        switch (operationSign) {
            case "b" :
                operation = Optional.of(Operation.BALANCE);
                break;
            case "s" :
                operation = Optional.of(Operation.SUPPLY);
                break;
            case "p" :
                operation = Optional.of(Operation.PURCHASE);
                break;
            case "r" :
                operation = Optional.of(Operation.RETURN);
                break;
        }
        return operation.orElseThrow(() -> new InvalidDataFormatException("The " + operationSign + " doesn't exist!"));
    }
}
