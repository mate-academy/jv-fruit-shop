package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
