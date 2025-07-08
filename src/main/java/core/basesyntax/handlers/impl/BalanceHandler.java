package core.basesyntax.handlers.impl;

import core.basesyntax.data.Storage;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.getAssortment().put(transaction.getFruit(), transaction.getQuantity());
    }
}
