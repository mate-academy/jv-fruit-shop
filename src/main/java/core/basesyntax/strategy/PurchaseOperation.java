package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        int curentQuantity = Storage.storage.get(transaction.getFruit().getType());
        if (curentQuantity >= transaction.getQuantity()) {
            Storage.storage.put(transaction.getFruit().getType(), curentQuantity - transaction.getQuantity());
        }
    }
}
