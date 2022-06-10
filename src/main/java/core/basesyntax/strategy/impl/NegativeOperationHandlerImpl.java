package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class NegativeOperationHandlerImpl implements OperationHandler {
    @Override
    public Integer getQuantity(FruitTransaction fruitTransaction) {
        return -fruitTransaction.getFruit().getQuantity();
    }
}
