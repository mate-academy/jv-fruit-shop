package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.updateFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
