package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerBalanceImpl implements OperationHandler {
    private Storage storage;

    public OperationHandlerBalanceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        validation(transaction.getQuantity());
        storage.STOCK_BALANCE.put(transaction.getFruit(), transaction.getQuantity());
    }

    private void validation(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Balance shouldn't be less 0. But it is "
                    + quantity);
        }
    }
}
