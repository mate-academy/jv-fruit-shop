package fruitshop.strategy.handler;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        int oldQuantity = Storage.fruits.get(transaction.getFruit());
        if (oldQuantity < transaction.getQuantity()) {
            throw new RuntimeException("there is not enough " + transaction.getFruit());
        }
        Storage.fruits.put(transaction.getFruit(), oldQuantity - transaction.getQuantity());
    }
}
