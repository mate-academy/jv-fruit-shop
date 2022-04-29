package strategy;

import db.Storage;
import model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operation(Fruit fruit, Integer quantity) {
        Integer initialQuantity = Storage.STORAGE.get(fruit);
        if (Storage.STORAGE.get(fruit) == null) {
            throw new RuntimeException("Null");
        }
        if (Storage.STORAGE.get(fruit) - quantity < 0) {
            throw new RuntimeException("Not enough of " + fruit + "'s");
        }
        Storage.STORAGE.put(fruit, initialQuantity - quantity);
    }
}
