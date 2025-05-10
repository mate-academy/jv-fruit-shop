package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void performOperation(FruitTransaction transaction) {
        Storage.storage.merge(transaction.getFruitName(), transaction.getQuantity(), Integer::sum);
    }
}
