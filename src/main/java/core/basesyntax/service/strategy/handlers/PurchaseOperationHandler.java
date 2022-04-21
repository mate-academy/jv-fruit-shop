package core.basesyntax.service.strategy.handlers;

import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void doOperation(String fruitName, Integer value) {
        Storage.addToDataBase(fruitName,
                Storage.getByKey(fruitName) - value);
    }
}
