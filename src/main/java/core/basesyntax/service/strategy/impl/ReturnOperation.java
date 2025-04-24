package core.basesyntax.service.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        Storage storage = new StorageImpl();
        storage.updateFruitBalance(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
