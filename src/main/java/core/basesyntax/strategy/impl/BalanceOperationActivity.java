package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationActivity;

public class BalanceOperationActivity implements OperationActivity {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        Storage.fruitTransactionsMap.put(transaction.getFruit(), transaction.getQuantity());
    }
}

