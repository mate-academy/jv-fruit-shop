package core.service.operation;

import core.db.Storage;
import core.model.FruitTransaction;

public class SupplyOperationHandlerImpl implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int transactionQuantity = transaction.getQuantity();
        if (Storage.storage.containsKey(fruitName)) {
            int updatedQuantity = Storage.storage.get(fruitName) + transactionQuantity;
            Storage.storage.replace(fruitName, updatedQuantity);
        }
    }
}
