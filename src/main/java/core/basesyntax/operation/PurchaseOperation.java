package core.basesyntax.operation;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        int oldQuantity = Storage.getFruitStorage().getOrDefault(transaction.getFruit(), transaction.getQuantity());
        if (oldQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough fruit. The transaction could not be completed.");
        }
        Storage.getFruitStorage().put(transaction.getFruit(),
                oldQuantity - transaction.getQuantity());
    }
}
