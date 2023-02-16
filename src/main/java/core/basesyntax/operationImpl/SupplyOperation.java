package core.basesyntax.operationImpl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationStrategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        int oldQuantity = transaction.getQuantity();
        Storage.fruitStorage.put(transaction.getFruit(), oldQuantity + transaction.getQuantity());
    }
}
