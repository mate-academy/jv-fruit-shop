package strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int operationHandle(FruitTransaction fruitTransaction) {
        Integer fruitQuantity = Storage.storage.get(fruitTransaction.getFruit());
        if (fruitQuantity == null || fruitQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("There are no enough fruits in storage");
        }
        Storage.storage.replace(fruitTransaction.getFruit(),
                fruitQuantity - fruitTransaction.getQuantity());
        return Storage.storage.get(fruitTransaction.getFruit());
    }
}
