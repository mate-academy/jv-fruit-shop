package core.basesyntax.service.operationhandler;

import static core.basesyntax.db.ShopDataBase.SHOP_DATA;

import core.basesyntax.service.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        int oldQuantity = SHOP_DATA.get(fruitTransaction.getFruit());
        SHOP_DATA.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity() + oldQuantity);
    }
}
