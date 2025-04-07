package core.basesyntax.service.operationhandler;

import core.basesyntax.db.ShopDataBase;
import core.basesyntax.service.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        int oldQuantity = ShopDataBase.getValue(fruitTransaction.getFruit());
        ShopDataBase.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity() + oldQuantity);
    }
}
