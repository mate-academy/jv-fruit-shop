package core.basesyntax.service.impl.operationhadler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        FruitStorage.fruitsStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
