package core.basesyntax.service.impl;

import core.basesyntax.Main;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionStrategyService;

public class PurchaseTransactionService implements TransactionStrategyService {

    @Override
    public void calculateTransaction(FruitTransaction fruitTransaction) {
        Main.getFruitStorage().removeFruit(fruitTransaction.getFruit(),
                fruitTransaction.getCount());
    }
}
