package core.basesyntax.service.handles;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandle;

public class PurchaseHandle implements OperationHandle {
    @Override
    public void handle(FruitTransaction transaction) {
        Integer quantity = Storage.storage.get(transaction.getFruit());

        if (quantity - transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Amount can`t be less then zero");
        }
        Storage.storage.put(transaction.getFruit(), quantity - transaction.getQuantity());
    }
}
