package core.basesyntax.service.impl;

import core.basesyntax.Main;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;

public class BalanceTransactionService implements TransactionService {
    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        Main.getFruitStorage().addFruit(fruitTransaction.getFruit(), fruitTransaction.getCount());
    }
}
