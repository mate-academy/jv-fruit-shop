package core.basesyntax.strategy.transaction;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        Storage.fruitMap.put(transaction.getFruit(), transaction.getQuantity()
                + Storage.fruitMap.get(transaction.getFruit()));
    }
}
