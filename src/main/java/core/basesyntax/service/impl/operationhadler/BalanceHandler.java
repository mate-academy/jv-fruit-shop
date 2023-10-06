package core.basesyntax.service.impl.operationhadler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        Storage.fruitsStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
