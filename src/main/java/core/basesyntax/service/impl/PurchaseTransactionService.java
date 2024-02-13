package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;

public class PurchaseTransactionService implements TransactionService {
    @Override
    public void executeTransaction(FruitTransaction fruitTransaction, FruitStorage fruitStorage) {
        fruitStorage.removeFruit(fruitTransaction.getFruit(), fruitTransaction.getCount());
    }
}
