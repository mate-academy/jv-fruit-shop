package core.basesyntax.service.operationhandler;

import static core.basesyntax.db.ShopDataBase.SHOP_DATA;

import core.basesyntax.service.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        SHOP_DATA.put(fruitTransaction.getFruit(),fruitTransaction.getQuantity());
    }
}
