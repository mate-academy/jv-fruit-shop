package core.basesyntax.strategy.transaction;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceTransactionHandlerImpl implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.fruitsMap.put(transaction.getFruit(), transaction.getQuantity());
    }
}
