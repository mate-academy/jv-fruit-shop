package core.basesyntax.service.operationhandler;

import core.basesyntax.db.ShopDataBase;
import core.basesyntax.service.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        int oldQuantity = ShopDataBase.getValue(fruitTransaction.getFruit());
        int newQuantity = oldQuantity - fruitTransaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough fruits in the storage");
        }
        ShopDataBase.put(fruitTransaction.getFruit(), newQuantity);
    }
}
