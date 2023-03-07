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
        int quantityBeforeSupply = storage.STOCK_BALANCE.get(transaction.getFruit());
        int quantityAfterSupply = quantityBeforeSupply + transaction.getQuantity();
        validation(quantityAfterSupply);
        storage.STOCK_BALANCE.put(transaction.getFruit(), quantityAfterSupply);
    }

    private void validation(int quantityAfterSupply) {
        if (quantityAfterSupply <= 0) {
            throw new RuntimeException("The return quantity must be over 0. But it is "
                    + quantityAfterSupply);
        }
    }
}
