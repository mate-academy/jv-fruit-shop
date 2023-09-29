package core.basesyntax.service.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void transaction(FruitTransaction transaction) {
        Storage.fruitBalance.put(transaction.getFruit(), transaction.getQuantity());
    }
}
