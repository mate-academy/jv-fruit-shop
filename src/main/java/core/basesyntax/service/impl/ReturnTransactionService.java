package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;

public class ReturnTransactionService implements TransactionService {
    @Override
    public void executeTransaction(FruitTransaction fruitTransaction, FruitStorage fruitStorage) {
        fruitStorage.addFruit(fruitTransaction.getFruit(), fruitTransaction.getCount());
    }
}
