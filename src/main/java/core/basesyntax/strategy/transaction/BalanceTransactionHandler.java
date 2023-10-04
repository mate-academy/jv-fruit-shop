package core.basesyntax.strategy.transaction;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.fruitMap.put(transaction.getFruit(), transaction.getQuantity());
    }
}
