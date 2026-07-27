package core.basesyntax.parse;

import core.basesyntax.model.FruitTransaction;

public class OperationParserImpl implements OperationParser {

    @Override
    public FruitTransaction.Operation getOperation(String code) {
        switch (code) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "s":
                return FruitTransaction.Operation.SUPPLY;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "r":
                return FruitTransaction.Operation.RETURN;
            default:
                throw new IllegalArgumentException(
                        "Unknown operation: " + code);
        }
    }
}
