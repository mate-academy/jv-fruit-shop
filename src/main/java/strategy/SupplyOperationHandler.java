package strategy;

import db.Storage;
import model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer fruitQuantity = Storage.storage.get(fruitTransaction.getFruit());
        if (fruitQuantity == null) {
            Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        } else {
            Storage.storage.replace(fruitTransaction.getFruit(),
                    fruitQuantity + fruitTransaction.getQuantity());
        }
        Storage.storage.get(fruitTransaction.getFruit());
    }
}
