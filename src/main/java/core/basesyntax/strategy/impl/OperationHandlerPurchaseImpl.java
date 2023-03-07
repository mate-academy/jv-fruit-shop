package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerPurchaseImpl implements OperationHandler {
    private Storage storage;

    public OperationHandlerPurchaseImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int quantityBeforePurchase = storage.STOCK_BALANCE.get(transaction.getFruit());
        int quantityAfterPurchase = quantityBeforePurchase - transaction.getQuantity();
        validation(quantityAfterPurchase);
        storage.STOCK_BALANCE.put(transaction.getFruit(), quantityAfterPurchase);
    }

    private void validation(int quantityAfterPurchase) {
        if (quantityAfterPurchase < 0) {
            throw new RuntimeException("There are not enough "
                    + Math.abs(quantityAfterPurchase)
                    + " pieces in stock to complete the sale");
        }
    }
}
