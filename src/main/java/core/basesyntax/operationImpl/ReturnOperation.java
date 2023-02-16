package core.basesyntax.operationImpl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationStrategy.OperationHandler;

public class ReturnOperation implements OperationHandler {

    @Override
    public void handleOperation(FruitTransaction transaction) {
        int oldQuantity = Storage.fruitStorage.get(transaction.getFruit());
        Storage.fruitStorage.put(transaction.getFruit(), oldQuantity + transaction.getQuantity());
    }
}
