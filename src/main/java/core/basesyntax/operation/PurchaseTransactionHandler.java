package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.storage.Storage;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void applyTransaction(FruitTransaction transaction) {
        Storage.storage.replace(transaction.getFruit(),
                Storage.storage.get(transaction.getFruit())
                        - transaction.getQuantity());
    }
}
