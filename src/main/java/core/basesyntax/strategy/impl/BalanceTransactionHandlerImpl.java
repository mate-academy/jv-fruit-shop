package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceTransactionHandlerImpl implements OperationHandler {

    @Override
    public void transaction(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruit().getFruitName(),
                transaction.getFruit().getQuantity());
    }
}
