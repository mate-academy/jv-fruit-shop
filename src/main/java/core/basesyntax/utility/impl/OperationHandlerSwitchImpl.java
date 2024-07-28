package core.basesyntax.utility.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.utility.OperationHandlerSwitch;

public class OperationHandlerSwitchImpl implements OperationHandlerSwitch {
    @Override
    public FruitTransaction.Operation getOperation(String operation) {
        return switch (operation) {
            case "b" -> FruitTransaction.Operation.BALANCE;
            case "s" -> FruitTransaction.Operation.SUPPLY;
            case "p" -> FruitTransaction.Operation.PURCHASE;
            case "r" -> FruitTransaction.Operation.RETURN;
            default -> throw new IllegalStateException("No such operation available " + operation);
        };
    }
}
