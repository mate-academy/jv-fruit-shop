package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.TransactionService;

public class FruitServiceImpl implements FruitService {
    @Override
    public void calculate(TransactionService transactionStrategy,
                          FruitTransaction fruitTransaction,
                          FruitStorage fruitStorage) {
        transactionStrategy.executeTransaction(fruitTransaction, fruitStorage);
    }
}
