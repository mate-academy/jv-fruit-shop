package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void performOperation(FruitTransaction transaction) {
        int currentQuantity = Storage.getStorage().get(transaction.getFruitName());
        Storage.getStorage().put(transaction.getFruitName(),
                currentQuantity + transaction.getQuantity());
    }
}
