package core.basesyntax.strategy.transaction;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyTransactionHandlerImpl implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.fruitsMap.putIfAbsent(transaction.getFruit(), 0);
        Storage.fruitsMap.put(transaction.getFruit(), transaction.getQuantity()
                + Storage.fruitsMap.get(transaction.getFruit()));
    }
}
