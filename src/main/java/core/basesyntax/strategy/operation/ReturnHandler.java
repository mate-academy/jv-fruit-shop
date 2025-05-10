package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public void getOperation(FruitTransaction transaction) {
        int previousValueBeforeOperation = Storage.storage
                .getOrDefault(transaction.getFruit(), 0);
        int currentValueAfterOperationPerforming =
                previousValueBeforeOperation + transaction.getQuantity();
        Storage.storage.put(transaction.getFruit(), currentValueAfterOperationPerforming);
    }
}
