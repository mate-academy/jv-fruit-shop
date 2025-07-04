package core.basesyntax.handlers.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.data.Storage;
import core.basesyntax.handlers.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String nameFruit = transaction.getFruit();
        int current = Storage.assortment.get(nameFruit);
        int res = current - transaction.getQuantity();
        if (res < 0) {
            throw new RuntimeException("Not enough " + nameFruit + " in storage!");
        }
        Storage.assortment.put(nameFruit, res);
    }
}
