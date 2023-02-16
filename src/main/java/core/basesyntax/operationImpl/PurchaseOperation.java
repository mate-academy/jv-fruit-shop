package core.basesyntax.operationImpl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationStrategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handleOperation(FruitTransaction transaction) {
        int oldQuantity = Storage.fruitStorage.get(transaction.getFruit());
        if (oldQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough fruit. The transaction could not be completed.");
        }
        Storage.fruitStorage.put(transaction.getFruit(), oldQuantity - transaction.getQuantity());
    }
}
