package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void applyTransaction(FruitTransaction transaction) {
        Storage.storage.replace(transaction.getFruit(),
                Storage.storage.get(transaction.getFruit())
                        - transaction.getQuantity());
    }
}
