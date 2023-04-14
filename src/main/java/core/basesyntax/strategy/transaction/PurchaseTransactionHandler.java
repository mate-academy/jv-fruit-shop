package core.basesyntax.strategy.transaction;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (Storage.fruitMap.get(transaction.getFruit()) < transaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in storage");
        }
        Storage.fruitMap.put(transaction.getFruit(),
                Storage.fruitMap.get(transaction.getFruit()) - transaction.getQuantity());
    }
}
