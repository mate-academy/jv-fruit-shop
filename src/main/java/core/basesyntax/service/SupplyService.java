package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.DataBase;

public class SupplyService implements OperationHandler {
    @Override
    public void operationHandler(FruitTransaction fruitTransaction) {
        DataBase.FRUIT_DATABASE.merge(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(), Integer::sum);
    }
}
