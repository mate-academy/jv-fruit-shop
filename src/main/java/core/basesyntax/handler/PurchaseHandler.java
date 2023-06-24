package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handler(FruitTransaction transaction) {
        if (Storage.storage.get(transaction.getFruit()) < transaction.getQuantity()) {
            throw new RuntimeException("We don`t have enough fruits in storage");
        }
        Storage.storage.put(transaction.getFruit(),
                Storage.storage.get(transaction.getFruit()) - transaction.getQuantity());
    }
}
