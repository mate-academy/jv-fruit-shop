package core.basesyntax.strategy.transaction;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseTransactionHandlerImpl implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (Storage.fruitsMap.get(transaction.getFruit()) < transaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in storage");
        }
        Storage.fruitsMap.put(transaction.getFruit(),
                Storage.fruitsMap.get(transaction.getFruit()) - transaction.getQuantity());
    }
}
