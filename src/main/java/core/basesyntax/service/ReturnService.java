package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.Database;

public class ReturnService implements OperationHandler {
    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        Database.database.merge(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(), Integer::sum);
    }
}
