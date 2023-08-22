package core.basesyntax.service.strategy;

import core.basesyntax.db.FruitDb;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        FruitDb.getBalanceMap().put(transaction.getFruitName(), transaction.getQuantity());
    }
}
