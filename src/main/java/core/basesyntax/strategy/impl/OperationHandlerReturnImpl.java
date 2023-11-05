package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerReturnImpl implements OperationHandler {
    private Storage storage;

    public OperationHandlerReturnImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        validation(transaction);
        int quantityBeforeSupply = storage.STOCK_BALANCE.get(transaction.getFruit());
        int quantityAfterSupply = quantityBeforeSupply + transaction.getQuantity();
        storage.STOCK_BALANCE.put(transaction.getFruit(), quantityAfterSupply);
    }

    private void validation(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("The return quantity must be over 0. But it is "
                    + transaction.getQuantity());
        }
    }
}
