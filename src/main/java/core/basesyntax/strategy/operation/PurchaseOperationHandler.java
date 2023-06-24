package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void evaluateTransaction(FruitTransaction transaction) {
        if (!Storage.storage.containsKey(transaction.getFruit())) {
            throw new RuntimeException("There no such fruits at the storage yet!");
        }
        int amountInStorage = Storage.storage.get(transaction.getFruit());
        if (amountInStorage < transaction.getQuantity()) {
            throw new RuntimeException("You can't purchase more than what is in storage!");
        }
        Storage.storage.put(transaction.getFruit(), amountInStorage - transaction.getQuantity());
    }
}
