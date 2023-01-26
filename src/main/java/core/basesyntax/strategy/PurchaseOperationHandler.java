package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void calculate(Transaction transaction) {
        int oldQuantity = Storage.fruitsStorage.get(transaction.getFruit());
        if (oldQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits for this purchase");
        } else {
            Storage.fruitsStorage
                    .put(transaction.getFruit(), oldQuantity - transaction.getQuantity());
        }
    }
}
