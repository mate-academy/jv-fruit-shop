package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionStrategyService;

public class ReturnTransactionService implements TransactionStrategyService {

    @Override
    public void calculateTransaction(FruitTransaction fruitTransaction) {
        FruitStorage.addFruit(fruitTransaction.getFruit(), fruitTransaction.getCount());
    }
}
