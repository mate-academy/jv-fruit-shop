package core.basesyntax.service.operationhandler;

import core.basesyntax.db.ShopDataBase;
import core.basesyntax.service.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        ShopDataBase.put(fruitTransaction.getFruit(),fruitTransaction.getQuantity());
    }
}
