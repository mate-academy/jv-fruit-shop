package core.basesyntax.service.Operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction == null) {
            throw new RuntimeException("Transaction is invalid");
        }
        String fruitName = transaction.getFruit();
        int quantityFruit = transaction.getQuantity();
        if (quantityFruit < 0) {
            throw new RuntimeException("Quantity must be greater or equals 0!");
        }
        Storage.storage.put(fruitName, quantityFruit);
    }
}
