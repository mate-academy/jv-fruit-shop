package core.basesyntax.service.impl;

import core.basesyntax.Main;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;

public class PurchaseTransactionService implements TransactionService {
    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        Main.getFruitStorage().removeFruit(fruitTransaction.getFruit(),
                                            fruitTransaction.getCount());
    }
}
