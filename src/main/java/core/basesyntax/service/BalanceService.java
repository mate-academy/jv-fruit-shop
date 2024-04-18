package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.DataBase;

public class BalanceService implements OperationHandler {
    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        DataBase.FRUIT_DATABASE.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
