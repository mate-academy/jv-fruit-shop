package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.Database;

public class PurchaseService implements OperationHandler {
    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        if (Database.database.get(fruitTransaction.getFruit())
                < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Sorry, but we haven't enough "
                    + fruitTransaction.getFruit());
        }
        Database.database.merge(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(),
                (existingValue, newValue) -> existingValue - newValue);
    }
}
