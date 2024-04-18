package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.DataBase;

public class PurchaseService implements OperationHandler {
    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        if (DataBase.FRUIT_DATABASE.get(fruitTransaction.getFruit())
                >= fruitTransaction.getQuantity()) {
            DataBase.FRUIT_DATABASE.merge(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity(),
                    (existingValue, newValue) -> existingValue - newValue);
        } else {
            throw new RuntimeException("Sorry, but we haven't enough "
                    + fruitTransaction.getFruit());
        }
    }
}
