package core.basesyntax.service.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void processTransaction(FruitTransaction transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
