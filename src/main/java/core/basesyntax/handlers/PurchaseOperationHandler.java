package core.basesyntax.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void calculateOperation(FruitTransaction transaction) {
        int currentAmount = Storage.STORAGE.get(transaction.getFruit());
        int quantity = transaction.getQuantity();
        int purchaseResult = currentAmount - quantity;
        if (purchaseResult < 0) {
            throw new RuntimeException("Not enough fruits in storage");
        }
        Storage.STORAGE.put(transaction.getFruit(), purchaseResult);
    }
}
