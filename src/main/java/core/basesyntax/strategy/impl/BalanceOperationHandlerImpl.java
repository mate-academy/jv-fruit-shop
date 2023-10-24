package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {

    @Override
    public void process(FruitTransaction transaction) {
        FruitStorage.fruitQuantities.put(transaction.getFruit(), transaction.getQuantity());
    }
}
