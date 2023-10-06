package core.basesyntax.service.impl.operationhadler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentValue = Storage.fruitsStorage.get(transaction.getFruit());
        Storage.fruitsStorage.put(transaction.getFruit(), currentValue
                + transaction.getQuantity());
    }
}
