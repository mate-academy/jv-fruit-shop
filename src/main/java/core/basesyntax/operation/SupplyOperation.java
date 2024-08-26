package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        Storage.storage.merge(fruitTransaction.getFruit(), fruitTransaction.getQuantity(), Integer::sum);
    }
}
