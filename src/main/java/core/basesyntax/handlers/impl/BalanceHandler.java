package core.basesyntax.handlers.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.data.Storage;
import core.basesyntax.handlers.OperationHandler;

public class BalanceHandler implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.assortment.put(transaction.getFruit(), transaction.getQuantity());
    }
}
