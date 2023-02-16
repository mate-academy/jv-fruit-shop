package core.basesyntax.operationImpl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationStrategy.OperationHandler;

public class BalanceOperation implements OperationHandler {

    @Override
    public void handleOperation(FruitTransaction transaction) {
        Storage.fruitStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
