package core.basesyntax.servise.strategy.impl;

import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.servise.strategy.OperationService;
import core.basesyntax.servise.strategy.OperationStrategies;

public class OperationStrategiesImpl implements OperationStrategies {

    @Override
    public OperationService getOperationHandler(FruitTransaction fruitTransaction) {
        return switch (fruitTransaction.getOperation()) {
            case BALANCE, SUPPLY, RETURN -> new IncomingOperationService(fruitTransaction);
            case PURCHASE -> new OutgoingOperationService(fruitTransaction);
        };
    }
}
