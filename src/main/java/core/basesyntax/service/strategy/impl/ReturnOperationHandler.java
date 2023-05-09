package core.basesyntax.service.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void transaction(FruitTransaction transaction) {
        int quantity = Storage.fruitBalance.get(transaction.getFruit());
        Storage.fruitBalance.put(transaction.getFruit(), quantity + transaction.getQuantity());
    }
}
