package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionStrategyService;

public class PurchaseTransactionService implements TransactionStrategyService {

    @Override
    public void calculateTransaction(FruitTransaction fruitTransaction) {
        FruitStorage.removeFruit(fruitTransaction.getFruit(),
                fruitTransaction.getCount());
    }
}
