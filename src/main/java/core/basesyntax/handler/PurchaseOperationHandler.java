package core.basesyntax.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void get(FruitTransaction transaction) {
        int current = Storage.fruitStorage.get(transaction.getFruit());
        Storage.fruitStorage.put(transaction.getFruit(), current - transaction.getQuantity());
    }
}

