package core.service.operation;

import core.db.Storage;
import core.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void operation(FruitTransaction transaction) {
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
