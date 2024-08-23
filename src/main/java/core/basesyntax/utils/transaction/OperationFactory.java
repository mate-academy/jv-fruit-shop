package core.basesyntax.utils.transaction;

import core.basesyntax.exceptions.UnknownOperationException;

public class OperationFactory {
    public static FruitTransaction.Operation getOperationFromString(String operationString) {
        return switch (operationString) {
            case "b" -> FruitTransaction.Operation.BALANCE;
            case "s" -> FruitTransaction.Operation.SUPPLY;
            case "p" -> FruitTransaction.Operation.PURCHASE;
            case "r" -> FruitTransaction.Operation.RETURN;
            default -> throw new UnknownOperationException("The operation provided is invalid");
        };
    }
}
