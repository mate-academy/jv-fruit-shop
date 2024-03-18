package core.basesyntax.service.handles;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handler(FruitTransaction transaction) {
        Integer quantity = Storage.storage.get(transaction.getFruit());

        if (quantity - transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Amount can`t be less then zero");
        }
        Storage.storage.put(transaction.getFruit(), quantity - transaction.getQuantity());
    }
}
