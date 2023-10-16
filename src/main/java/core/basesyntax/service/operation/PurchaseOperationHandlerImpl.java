package core.basesyntax.service.Operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int transactionQuantity = transaction.getQuantity();
        if (Storage.storage.containsKey(fruitName)) {
            int updatedQuantity = Storage.storage.get(fruitName) - transactionQuantity;
            if (updatedQuantity < 0) {
                throw new RuntimeException("We don't have enough fruits!");
            }
            Storage.storage.replace(fruitName, updatedQuantity);
        }
    }
}
