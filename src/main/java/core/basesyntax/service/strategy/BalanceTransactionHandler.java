package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;

public class BalanceTransactionHandler implements FruitTransactionHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction, Storage storage) {
        storage.getStorageMap().put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
