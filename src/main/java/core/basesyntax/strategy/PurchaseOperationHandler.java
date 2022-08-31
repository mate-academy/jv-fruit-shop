package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        int curentQuantity = Storage.getStorage().get(transaction.getFruit());
        if (curentQuantity >= transaction.getQuantity()) {
            Storage.getStorage().put(transaction.getFruit(),
                    curentQuantity - transaction.getQuantity());
        }
    }
}
