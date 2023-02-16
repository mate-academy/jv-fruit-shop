package core.basesyntax.operationimpl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationstrategy.OperationHandler;

public class SupplyOperation implements OperationHandler {

    @Override
    public void handleOperation(FruitTransaction transaction) {
        int oldQuantity = Storage.getFruitStorage().get(transaction.getFruit());
        Storage.getFruitStorage().put(transaction.getFruit(),
                oldQuantity + transaction.getQuantity());
    }
}
