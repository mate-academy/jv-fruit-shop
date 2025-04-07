package core.basesyntax.service.operationhandler;

import core.basesyntax.db.ShopDataBase;
import core.basesyntax.service.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        int oldQuantity = ShopDataBase.getValue(fruitTransaction.getFruit());
        if (oldQuantity - fruitTransaction.getQuantity() < oldQuantity) {
            throw new RuntimeException("Not enough fruits in the storage");
        }
        ShopDataBase.put(fruitTransaction.getFruit(), oldQuantity - fruitTransaction.getQuantity());
    }
}
