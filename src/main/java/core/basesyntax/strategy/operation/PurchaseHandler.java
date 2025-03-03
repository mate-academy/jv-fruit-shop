package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void getOperation(FruitTransaction transaction) {
        int previousValueBeforeOperation = Storage.storage.get(transaction.getFruit());
        int currentValueAfterOperationPerforming = previousValueBeforeOperation - transaction.getQuantity();
        if (currentValueAfterOperationPerforming <= 0) {
            throw new RuntimeException("The balance value after performing purchase operation will be negative.");
        }
        Storage.storage.put(transaction.getFruit(), currentValueAfterOperationPerforming);
    }
}
