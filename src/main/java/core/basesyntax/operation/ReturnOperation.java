package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        Storage.storage.merge(fruitTransaction.getFruit(), fruitTransaction.getAmount(),
                Integer::sum);
    }
}
