package core.basesyntax.service.strategy;

import core.basesyntax.db.FruitDb;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        Integer currentQuantity = FruitDb.getBalanceMap().get(transaction.getFruitName());
        FruitDb.getBalanceMap().put(transaction.getFruitName(),
                currentQuantity + transaction.getQuantity());
    }
}
