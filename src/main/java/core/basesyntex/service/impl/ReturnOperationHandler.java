package core.basesyntex.service.impl;

import core.basesyntex.model.FruitTransaction;
import core.basesyntex.service.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.updateStorage(transaction.getFruit(), transaction.getQuantity());
    }
}
