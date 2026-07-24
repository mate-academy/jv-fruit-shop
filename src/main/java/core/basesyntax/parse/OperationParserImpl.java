package core.basesyntax.parse;

import core.basesyntax.model.FruitTransaction;

public class OperationParserImpl implements OperationParser {
    @Override
    public FruitTransaction.Operation getOperation(String code) {
        return switch (code) {
            case "b" -> FruitTransaction.Operation.BALANCE;
            case "s" -> FruitTransaction.Operation.SUPPLY;
            case "p" -> FruitTransaction.Operation.PURCHASE;
            case "r" -> FruitTransaction.Operation.RETURN;
            default -> throw new IllegalArgumentException("Unknown operation: " + code);
        };
    }
}
