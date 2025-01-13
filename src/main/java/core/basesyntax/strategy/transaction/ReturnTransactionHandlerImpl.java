package core.basesyntax.strategy.transaction;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnTransactionHandlerImpl implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.fruitsMap.put(transaction.getFruit(),
                Storage.fruitsMap.get(transaction.getFruit()) + transaction.getQuantity());
    }
}
