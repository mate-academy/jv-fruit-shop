package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseTransactionHandlerImpl implements OperationHandler {

    @Override
    public void transaction(FruitTransaction transaction) {
        int oldQuantity = Storage.fruits.get(transaction.getFruit().getFruitName());
        Storage.fruits.put(transaction.getFruit().getFruitName(),
                oldQuantity - transaction.getFruit().getQuantity());
    }
}
