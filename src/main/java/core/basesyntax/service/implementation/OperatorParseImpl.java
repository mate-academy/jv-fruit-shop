package core.basesyntax.service.implementation;

import core.basesyntax.service.OperationType;
import core.basesyntax.service.OperatorParse;

public class OperatorParseImpl implements OperatorParse {
    @Override
    public OperationType parse(String operationName) {
        switch (operationName) {
            case "b":
                return OperationType.BALANCE;
            case "s":
                return OperationType.SUPPLY;
            case "p":
                return OperationType.PURCHASE;
            case "r":
                return OperationType.RETURN;
            default:
                throw new RuntimeException("No such operator " + operationName);
        }
    }
}
