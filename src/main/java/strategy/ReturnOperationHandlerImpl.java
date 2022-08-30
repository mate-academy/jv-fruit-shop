package strategy;

import model.FruitTransaction;
import storage.Storage;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public int handle(FruitTransaction fruitTransaction) {
        Integer fruitQuantity = Storage.storage.get(fruitTransaction.getFruit());
        if (fruitQuantity == null) {
            throw new RuntimeException("We don't have fruit - " + fruitTransaction.getFruit());
        }
        Storage.storage.replace(fruitTransaction.getFruit(),
                fruitQuantity + fruitTransaction.getQuantity());
        return Storage.storage.get(fruitTransaction.getFruit());
    }
}
