package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void changeReportInStorage(Transaction transaction) {
        if (Storage.fruitStorage.containsKey(transaction.getFruit())) {
            if (Storage.fruitStorage.get(transaction.getFruit()) >= transaction.getQuantity()) {
                Storage.fruitStorage.put(transaction.getFruit(),
                        Storage.fruitStorage.get(transaction.getFruit())
                                - transaction.getQuantity());
            } else {
                throw new RuntimeException("Not enough fruits in storage");
            }
        } else {
            throw new RuntimeException("Not such fruit in storage");
        }
    }
}
