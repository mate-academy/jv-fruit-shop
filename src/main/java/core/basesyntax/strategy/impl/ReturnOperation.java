package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationService;

public class ReturnOperation implements OperationService {
    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        int balance = Storage.getStorage().get(fruitTransaction.getFruit());
        int retOperation = balance + fruitTransaction.getQuantity();
        Storage.getStorage().put((fruitTransaction.getFruit()),retOperation);
    }
}
