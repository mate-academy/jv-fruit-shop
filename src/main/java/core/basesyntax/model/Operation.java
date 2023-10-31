package core.basesyntax.model;

import core.basesyntax.exception.InvalidDataFormatException;
import java.util.Optional;

public enum Operation {
    BALANCE,
    SUPPLY,
    PURCHASE,
    RETURN;

    public static Operation of(String operationSign) {
        Optional<Operation> operation;

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
            default:
                operation = Optional.empty();
        }
        return operation.orElseThrow(() -> new InvalidDataFormatException("The " + operationSign
                                                                            + " doesn't exist!"));
    }
}
