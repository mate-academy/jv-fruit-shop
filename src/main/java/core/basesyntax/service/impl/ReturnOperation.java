package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.getFruits().merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
