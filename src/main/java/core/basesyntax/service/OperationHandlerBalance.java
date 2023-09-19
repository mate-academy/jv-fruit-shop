package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class OperationHandlerBalance implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.result.put(transaction.getFruit(), transaction.getQuantity());
    }
}
