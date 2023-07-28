package core.basesyntax.service.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        if (Storage.storage.get(transaction.getFruit()) > transaction.getQuantity()) {
            Storage.storage.replace(transaction.getFruit(),
                    Storage.storage.get(transaction.getFruit()) - transaction.getQuantity());
        }
    }
}
