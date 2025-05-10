package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.Database;

public class BalanceService implements OperationHandler {
    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        Database.database.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
