package strategy;

import db.Storage;
import model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int operationHandle(FruitTransaction fruitTransaction) {
        Integer fruitQuantity = Storage.storage.get(fruitTransaction.getFruit());
        if (fruitQuantity == null) {
            Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        } else {
            Storage.storage.replace(fruitTransaction.getFruit(),
                    fruitQuantity + fruitTransaction.getQuantity());
        }
        return Storage.storage.get(fruitTransaction.getFruit());
    }
}
