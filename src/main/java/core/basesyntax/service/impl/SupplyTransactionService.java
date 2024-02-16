package core.basesyntax.service.impl;

import core.basesyntax.Main;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionStrategyService;

public class SupplyTransactionService implements TransactionStrategyService {

    @Override
    public void calculateTransaction(FruitTransaction fruitTransaction) {
        Main.getFruitStorage().addFruit(fruitTransaction.getFruit(), fruitTransaction.getCount());
    }
}
