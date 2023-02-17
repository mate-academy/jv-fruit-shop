package core.basesyntax.operation;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        int oldQuantity = Storage.getFruitStorage().getOrDefault(transaction.getFruit(), 0);
        Storage.getFruitStorage().put(transaction.getFruit(),
                oldQuantity + transaction.getQuantity());
    }
}
