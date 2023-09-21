package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class OperationHandlerBalance implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.result.put(transaction.getFruit(), transaction.getQuantity());
    }
}
