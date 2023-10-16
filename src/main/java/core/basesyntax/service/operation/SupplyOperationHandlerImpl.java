package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandlerImpl implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity can be greater than zero");
        }
        String fruitName = transaction.getFruit();
        int transactionQuantity = transaction.getQuantity();
        if (Storage.storage.containsKey(fruitName)) {
            int updatedQuantity = Storage.storage.get(fruitName) + transactionQuantity;
            Storage.storage.replace(fruitName, updatedQuantity);
        }
    }
}
