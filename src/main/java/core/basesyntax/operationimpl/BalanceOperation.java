package core.basesyntax.operationimpl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationstrategy.OperationHandler;

public class BalanceOperation implements OperationHandler {

    @Override
    public void handleOperation(FruitTransaction transaction) {
        Storage.getFruitStorage().put(transaction.getFruit(), transaction.getQuantity());
    }
}
